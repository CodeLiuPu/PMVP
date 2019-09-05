package com.update.base.mvp.presenter;

import com.uber.autodispose.AutoDisposeConverter;
import com.update.base.mvp.model.BaseMVPModel;
import com.update.base.mvp.view.BaseMVPView;

/**
 * @author : liupu
 * date   : 2019/4/15
 * desc   :
 * github : https://github.com/CodeLiuPu/
 */
public abstract class BaseMVPPresenter<V extends BaseMVPView, M extends BaseMVPModel> {
    protected V mView;
    protected M mModel;

    public BaseMVPPresenter() {

    }

    public void attachView(V view) {
        this.mView = view;
        this.mModel = initModel();
    }

    public void detachView() {
        this.mView = null;
    }

    protected abstract M initModel();

    protected <T> AutoDisposeConverter<T> bindAutoDispose() {
        return mView.bindAutoDispose();
    }
}