package com.update.pmvp.ui.main.contract;

import com.update.module_base.mvp.model.BaseMVPModel;
import com.update.module_base.mvp.view.BaseMVPView;

/**
 * @author : liupu
 * date   : 2019/4/19
 * desc   :
 */
public class MainContract {

    public interface Model extends BaseMVPModel {
         String  loadData();
    }
    public interface View extends BaseMVPView {
        void loadDataSuccess(String content);
    }

    public interface Presenter{
        void loadData();
    }
}
