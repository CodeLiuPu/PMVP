package com.update.base.mvp.presenter;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;

import com.uber.autodispose.AutoDisposeConverter;
import com.update.base.mvp.model.BaseMVPModel;
import com.update.base.mvp.view.BaseMVPView;
import com.update.base.utils.log.LogUtil;

/**
 * @author : liupu
 * date   : 2019/4/15
 * desc   :
 * github : https://github.com/CodeLiuPu/
 */
public abstract class BaseMVPPresenter<V extends BaseMVPView, M extends BaseMVPModel>  implements
        LifecycleObserver{
    protected V mView;
    protected M mModel;

    public BaseMVPPresenter() {

    }

    public void attachView(V view) {
        this.mView = view;
        this.mModel = createModel();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    void onStop() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void onDestroy() {
        this.mView = null;
        this.mModel = null;
    }

    protected abstract M createModel();

    protected <T> AutoDisposeConverter<T> bindAutoDispose() {
        return mView.bindAutoDispose();
    }
}