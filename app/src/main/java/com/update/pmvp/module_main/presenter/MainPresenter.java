package com.update.pmvp.module_main.presenter;

import com.update.module_base.base.presenter.BasePresenter;
import com.update.pmvp.module_main.contract.MainContract;
import com.update.pmvp.module_main.model.MainModel;

/**
 * @author : liupu
 * date   : 2019/4/19
 * desc   :
 */
public class MainPresenter extends BasePresenter<MainContract.View, MainModel> implements MainContract.Presenter {

    @Override
    public MainModel initModel() {
        return MainModel.instance();
    }

    @Override
    public void loadData() {
        String name = mModel.getUserName();
        mView.updateUI(name);
    }
}
