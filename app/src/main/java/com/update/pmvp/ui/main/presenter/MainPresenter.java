package com.update.pmvp.ui.main.presenter;

import com.update.module_base.mvp.presenter.BaseMVPPresenter;
import com.update.pmvp.ui.main.contract.MainContract;
import com.update.pmvp.ui.main.model.MainModel;

/**
 * @author : liupu
 * date   : 2019/4/19
 * desc   :
 */
public class MainPresenter extends BaseMVPPresenter<MainContract.View, MainContract.Model> implements MainContract.Presenter {

    @Override
    public void loadData() {
        String name = mModel.loadData();
        mView.loadDataSuccess(name);
    }

    @Override
    protected MainContract.Model initModel() {
        return new MainModel();
    }

}