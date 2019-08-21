package com.update.pmvp.module_main.model;

import com.update.pmvp.module_main.contract.MainContract;

/**
 * @author : liupu
 * date   : 2019/4/19
 * desc   :
 */
public class MainModel implements MainContract.Model {

    private MainModel() {

    }

    public static MainModel instance() {
        return Holder.MODEL;
    }

    private static class Holder {
        public static final MainModel MODEL = new MainModel();
    }


    @Override
    public String getUserName() {
        return "Update";
    }


}
