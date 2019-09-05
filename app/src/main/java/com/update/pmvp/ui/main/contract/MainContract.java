package com.update.pmvp.ui.main.contract;

import com.update.base.mvp.model.BaseMVPModel;
import com.update.base.mvp.view.BaseMVPView;
import com.update.net.response.BaseResult;

import io.reactivex.Observable;

/**
 * @author : liupu
 * date   : 2019/4/19
 * desc   :
 * github : https://github.com/CodeLiuPu/
 */
public class MainContract {

    public interface Model extends BaseMVPModel {
        Observable<BaseResult<String>> loadData();
    }

    public interface View extends BaseMVPView {
        void loadDataSuccess(String content);
    }

    public interface Presenter {
        void loadData();
    }
}
