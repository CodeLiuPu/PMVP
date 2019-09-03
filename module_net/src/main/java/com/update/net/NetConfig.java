package com.update.net;

/**
 * @author : liupu
 * date    : 2019/8/23
 * desc    :
 * github : https://github.com/CodeLiuPu/
 */
public class NetConfig {
    private static boolean isDebug = true;

    public static void setDebug(boolean isDebug) {
        NetConfig.isDebug = isDebug;
    }

    public static boolean isDebug() {
        return isDebug;
    }

}
