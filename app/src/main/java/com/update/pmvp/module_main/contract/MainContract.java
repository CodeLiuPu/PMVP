package com.update.pmvp.module_main.contract;

import com.update.module_base.base.contract.IContract;

/**
 * @author : liupu
 * date   : 2019/4/19
 * desc   :
 */
public class MainContract {
    public interface View extends IContract.View {
        void updateUI(String content);
    }

    public interface Presenter extends IContract.Presenter<View> {
        void loadData();
    }
}
