package com.update.module_base.mvp.presenter;

import com.update.module_base.mvp.model.BaseMVPModel;
import com.update.module_base.mvp.view.BaseMVPView;

/**
 * @author : liupu
 * date   : 2019/4/15
 * desc   :
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

}