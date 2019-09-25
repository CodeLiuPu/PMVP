package com.update.pmvp.ui.main.presenter;


import android.support.annotation.NonNull;

import com.update.base.mvp.presenter.BaseMVPPresenter;
import com.update.base.utils.log.LogUtil;
import com.update.net.response.BaseObserver;
import com.update.net.response.BaseResult;
import com.update.net.scheduler.RxScheduler;
import com.update.pmvp.ui.main.contract.MainContract;
import com.update.pmvp.ui.main.model.MainModel;

/**
 * @author : liupu
 * date   : 2019/4/19
 * desc   :
 * github : https://github.com/CodeLiuPu/
 */
public class MainPresenter extends BaseMVPPresenter<MainContract.View, MainContract.Model> implements MainContract.Presenter {

    public MainPresenter(MainContract.View view) {
        super(view);
    }

    @Override
    public void loadData() {
        mModel.loadData()
                .compose(RxScheduler.Obs_io_main())
                .as(bindAutoDispose())
                .subscribe(new BaseObserver<BaseResult<String>>() {

                    @Override
                    public void onSuccess(@NonNull BaseResult<String> data) {
                        LogUtil.e("onSuccess " + data.result);
                        mView.loadDataSuccess(data.result);
                    }

                    @Override
                    public void onFail(String code, String msg) {
                        LogUtil.e("code " + msg);
                        mView.loadDataSuccess(msg);
                    }

                });

    }

    @Override
    protected MainContract.Model createModel() {
        return new MainModel();
    }

}
