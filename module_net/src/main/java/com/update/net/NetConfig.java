package com.update.net;

import com.update.net.interceptor.log.Level;

/**
 * @author : liupu
 * date    : 2019/8/23
 * desc    :
 * github : https://github.com/CodeLiuPu/
 */
public class NetConfig {

    private static boolean isDebug = false;
    private static Level level = Level.INFO;
    private static String tag = "okhttp_tag_default";

    public NetConfig setDebug(boolean isDebug) {
        NetConfig.isDebug = isDebug;
        return this;
    }

    public static boolean isDebug() {
        return isDebug;
    }

    public NetConfig setLogLevel(Level level) {
        NetConfig.level = level;
        return this;
    }

    public static Level logLevel() {
        return level;
    }

    public NetConfig setTag(String tag) {
        NetConfig.tag = tag;
        return this;
    }

    public static String tag() {
        return tag;
    }

}
