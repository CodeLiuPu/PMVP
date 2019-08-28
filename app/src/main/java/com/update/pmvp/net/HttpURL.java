package com.update.pmvp.net;

import com.update.pmvp.BuildConfig;

/**
 * @author : liupu
 * date   : 2019/8/23
 * desc   :
 * github : https://github.com/CodeLiuPu/
 */
public class HttpURL {
    private static final String sHost;

    public static String baseUrl() {
        return sHost;
    }

    static {
        sHost = BuildConfig.DEBUG ? "https://www.baidu.com/" : "https://www.baidu.com/";
    }

    public static final String HTTP_GET = "/app/get";

    public static String HTTP_POST = "/app/post";

}
