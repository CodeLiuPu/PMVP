package com.update.base.ui.activity;

import com.update.base.mvp.presenter.BaseMVPPresenter;
import com.update.base.mvp.view.BaseMVPView;

/**
 * @author : liupu
 * date   : 2019/4/19
 * desc   :
 * github : https://github.com/CodeLiuPu/
 */
public abstract class BaseMvpActivity<P extends BaseMVPPresenter>
        extends BaseSimpleActivity
        implements BaseMVPView {
    protected P mPresenter;

    @Override
    protected void initView() {
        mPresenter = initPresenter();
        if (null != mPresenter) {
            mPresenter.attachView(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != mPresenter) {
            mPresenter.detachView();
            mPresenter = null;
        }
    }

    protected abstract P initPresenter();

}
