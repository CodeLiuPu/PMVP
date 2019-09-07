package com.update.base.ui.fragment;

import android.arch.lifecycle.Lifecycle;

import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.AutoDisposeConverter;
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;
import com.update.base.mvp.presenter.BaseMVPPresenter;
import com.update.base.mvp.view.BaseMVPView;

/**
 * @author : liupu
 * date    : 2019/9/7
 * desc    :
 * github : https://github.com/CodeLiuPu/
 */
public abstract class BaseMvpFragment
        <P extends BaseMVPPresenter>
        extends BaseSimpleFragment
        implements BaseMVPView {

    protected P mPresenter;

    @Override
    protected void initView() {
        super.initView();
        mPresenter = initPresenter();
        if (null != mPresenter) {
            mPresenter.attachView(this);
        }
    }

    @Override
    public void onDestroyView() {
        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter = null;
        }
        super.onDestroyView();
    }

    protected abstract P initPresenter();

    /**
     * 绑定生命周期 防止MVP内存泄漏
     *
     * @param <T>
     * @return
     */
    @Override
    public final <T> AutoDisposeConverter<T> bindAutoDispose() {
        return AutoDispose.autoDisposable(AndroidLifecycleScopeProvider
                .from(this, Lifecycle.Event.ON_DESTROY));
    }
}
