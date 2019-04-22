package com.update.pmvp.module_main.model;

import com.update.module_base.base.model.BaseModel;

/**
 * @author : liupu
 *  date   : 2019/4/19
 *  desc   :
 */
public class MainModel extends BaseModel {

    private MainModel(){

    }

    public static MainModel instance(){
        return Holder.MODEL;
    }

    private static class Holder{
        public static final MainModel MODEL = new MainModel();
    }




    public String getUserName() {
        return "Update";
    }


}
