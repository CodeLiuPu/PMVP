package com.update.base.ui.activity;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.support.annotation.Nullable;

import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.AutoDisposeConverter;
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;
import com.update.base.mvp.presenter.BaseMVPPresenter;
import com.update.base.mvp.view.BaseMVPView;

/**
 * @author : liupu
 * date   : 2019/4/19
 * desc   :
 * github : https://github.com/CodeLiuPu/
 */
public abstract class BaseMvpActivity<P extends BaseMVPPresenter> extends BaseSimpleActivity
        implements BaseMVPView {
    protected P mPresenter;

    @Override
    protected void initView() {
        super.initView();
        mPresenter = initPresenter();
        if (null != mPresenter) {
            mPresenter.attachView(this);
            addObserver(mPresenter);
        }
    }

    protected abstract P initPresenter();

    /**
     * 绑定生命周期 防止MVP内存泄漏
     */
    @Override
    public final <T> AutoDisposeConverter<T> bindAutoDispose() {
        return AutoDispose.autoDisposable(AndroidLifecycleScopeProvider
                .from(this, Lifecycle.Event.ON_DESTROY));
    }

    @Override
    public <V extends LifecycleObserver> void addObserver(@Nullable V observer) {
        if (observer != null) {
            getLifecycle().addObserver(observer);
        }
    }
}
