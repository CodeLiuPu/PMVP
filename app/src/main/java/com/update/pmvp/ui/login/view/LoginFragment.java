package com.update.pmvp.ui.login.view;

import com.update.base.ui.fragment.BaseMvpFragment;
import com.update.pmvp.R;
import com.update.pmvp.ui.login.contract.LoginContract;
import com.update.pmvp.ui.login.presenter.LoginPresenter;

/**
 * @author : liupu
 * date    : 2019/9/8
 * desc    :
 * github : https://github.com/CodeLiuPu/
 */
public class LoginFragment extends BaseMvpFragment<LoginPresenter> implements LoginContract.View {
    @Override
    protected LoginPresenter initPresenter() {
        return new LoginPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_login;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void loginSuccess(String content) {

    }

}
