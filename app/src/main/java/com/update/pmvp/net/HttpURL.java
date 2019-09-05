package com.update.pmvp.net;

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
        sHost = "https://api.apiopen.top/";
    }

    public static final String HTTP_GET = "/recommendPoetry";

    public static String HTTP_POST = "/app/post";

}
