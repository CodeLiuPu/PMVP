package com.update.module_base.net;


/**
 * @author : liupu
 * date   : 2019/8/22
 * desc   : 网络返回数据的javaBean(泛型解析)
 */
public class NetEntity<T> extends BaseResult {

    public T data;

}
