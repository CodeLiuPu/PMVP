package com.update.module_base.base.contract;

/**
 * @author : liupu
 *  date   : 2019/4/15
 *  desc   :
 */
public interface IContract {
    interface View{
        void showProgress(int res);
        void dismissProgress();
    }
    interface Presenter<V extends View>{
        void attachView(V view);
        void detachView();
    }
}