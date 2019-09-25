package com.update.pmvp.ui.login.contract;

import com.update.base.mvp.model.BaseMVPModel;
import com.update.base.mvp.view.BaseMVPView;
import com.update.net.response.BaseResult;

import io.reactivex.Observable;

/**
 * @author : liupu
 * date    : 2019/9/8
 * desc    :
 * github : https://github.com/CodeLiuPu/
 */
public class LoginContract {

    public interface Model extends BaseMVPModel {
        Observable<BaseResult<String>> login();
    }

    public interface View extends BaseMVPView {
        void loginSuccess(String content);
    }

    public interface Presenter {
        void login();
    }
}
