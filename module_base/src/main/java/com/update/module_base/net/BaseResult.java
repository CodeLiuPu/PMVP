package com.update.module_base.net;


import java.io.Serializable;

public class BaseResult implements Serializable {

    public static final String STATE_SUCCESS = "200";

    /**
     * 0成功   1失败   -1异常
     */

    public String code;
    public String msg;

}