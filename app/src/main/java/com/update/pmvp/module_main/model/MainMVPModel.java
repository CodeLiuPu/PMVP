package com.update.pmvp.module_main.model;

import com.update.pmvp.module_main.contract.MainContract;

/**
 * @author : liupu
 * date   : 2019/4/19
 * desc   :
 */
public class MainMVPModel implements MainContract.Model {

    private MainMVPModel() {

    }

    public static MainMVPModel instance() {
        return Holder.MODEL;
    }

    private static class Holder {
        public static final MainMVPModel MODEL = new MainMVPModel();
    }


    @Override
    public String getUserName() {
        return "Update";
    }


}
