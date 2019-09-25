package com.update.pmvp.ui.login.presenter;


import android.support.annotation.NonNull;

import com.update.base.mvp.presenter.BaseMVPPresenter;
import com.update.base.utils.log.LogUtil;
import com.update.net.response.BaseObserver;
import com.update.net.response.BaseResult;
import com.update.net.scheduler.RxScheduler;
import com.update.pmvp.ui.login.contract.LoginContract;
import com.update.pmvp.ui.login.model.LoginModel;

/**
 * @author : liupu
 * date    : 2019/9/8
 * desc    :
 * github : https://github.com/CodeLiuPu/
 */
public class LoginPresenter extends BaseMVPPresenter<LoginContract.View, LoginContract.Model> implements LoginContract.Presenter {

    public LoginPresenter(LoginContract.View view) {
        super(view);
    }

    @Override
    public void login() {
        mModel.login()
                .compose(RxScheduler.Obs_io_main())
                .as(bindAutoDispose())
                .subscribe(new BaseObserver<BaseResult<String>>() {

                    @Override
                    public void onSuccess(@NonNull BaseResult<String> data) {
                        LogUtil.e("onSuccess " + data.result);
                        mView.loginSuccess(data.result);
                    }

                    @Override
                    public void onFail(String code, String msg) {
                        LogUtil.e("code " + msg);
                        mView.loginSuccess(msg);
                    }

                });
    }

    @Override
    protected LoginContract.Model createModel() {
        return new LoginModel();
    }

}
