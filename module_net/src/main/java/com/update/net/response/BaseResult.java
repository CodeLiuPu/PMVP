package com.update.net.response;


import java.io.Serializable;

/**
 * @author : liupu
 * date   : 2019/8/22
 * desc   : 网络返回数据的javaBean(泛型解析)
 * github : https://github.com/CodeLiuPu/
 */
public class BaseResult<T> implements Serializable {

    public String code;
    public String message;
    public T result;

}
