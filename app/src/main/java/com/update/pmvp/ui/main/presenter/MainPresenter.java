package com.update.pmvp.ui.main.presenter;


import com.update.base.mvp.presenter.BaseMVPPresenter;
import com.update.base.utils.log.LogUtil;
import com.update.net.response.BaseResult;
import com.update.net.scheduler.RxScheduler;
import com.update.pmvp.ui.main.contract.MainContract;
import com.update.pmvp.ui.main.model.MainModel;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author : liupu
 * date   : 2019/4/19
 * desc   :
 * github : https://github.com/CodeLiuPu/
 */
public class MainPresenter extends BaseMVPPresenter<MainContract.View, MainContract.Model> implements MainContract.Presenter {

    @Override
    public void loadData() {
        mModel.loadData()
                .compose(RxScheduler.Obs_io_main())
                .as(bindAutoDispose())
                .subscribe(new Observer<BaseResult<String>>() {

                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(BaseResult<String> result) {
                        LogUtil.e("onNext " + result.result);
                        mView.loadDataSuccess(result.result);
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtil.e("onError");
                    }

                    @Override
                    public void onComplete() {
                        LogUtil.e("onComplete");
                    }
                });

    }

    @Override
    protected MainContract.Model initModel() {
        return new MainModel();
    }

}
