package com.update.pmvp.ui.login.view;

import com.update.base.ui.activity.BaseSimpleActivity;
import com.update.base.utils.FragmentUtils;
import com.update.pmvp.R;

/**
 * @author : liupu
 * date    : 2019/9/8
 * desc    :
 * github : https://github.com/CodeLiuPu/
 */
public class LoginActivity extends BaseSimpleActivity {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        super.initView();
        FragmentUtils.addFragmentIntoActivity(this,new LoginFragment(), R.id.fl_container);

    }

    @Override
    protected void initData() {

    }
}
