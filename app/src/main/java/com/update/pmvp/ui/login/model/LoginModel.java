package com.update.pmvp.ui.login.model;

import com.update.net.response.BaseResult;
import com.update.pmvp.net.HttpManager;
import com.update.pmvp.ui.login.contract.LoginContract;

import io.reactivex.Observable;

/**
 * @author : liupu
 * date    : 2019/9/8
 * desc    :
 * github : https://github.com/CodeLiuPu/
 */
public class LoginModel implements LoginContract.Model {
    @Override
    public Observable<BaseResult<String>> login() {
        return  HttpManager.service().get();
    }

}
