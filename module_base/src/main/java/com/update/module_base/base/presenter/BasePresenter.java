package com.update.module_base.base.presenter;

import com.update.module_base.base.contract.IContract;
import com.update.module_base.base.model.BaseModel;

/**
 * author : liupu
 * date   : 2019/4/15
 * desc   :
 */
public abstract class BasePresenter<V extends IContract.View,M extends BaseModel>
        implements IContract.Presenter<V> {
    protected V  mView;
    protected M mModel;

    public BasePresenter(){

    }

    @Override
    public void attachView(V view) {
        this.mView = view;
        this.mModel = initModel();
    }

    @Override
    public void detachView() {
        this.mView = null;
    }

    protected abstract M initModel();

}