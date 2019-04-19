package com.update.module_base.base.activity;

import com.update.module_base.base.contract.IContract;

/**
 * author : liupu
 * date   : 2019/4/19
 * desc   :
 */
public abstract class BaseMvpActivity<P extends IContract.Presenter>
        extends BaseSimpleActivity
        implements IContract.View {
    protected P mPresenter;

    @Override
    protected void initView() {
        mPresenter = initPresenter();
        if (null != mPresenter){
            mPresenter.attachView(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != mPresenter){
            mPresenter.detachView();
            mPresenter = null;
        }
    }

    @Override
    public void showProgress(int progress) {

    }

    @Override
    public void dismissProgress() {

    }
    protected abstract P initPresenter();

}
