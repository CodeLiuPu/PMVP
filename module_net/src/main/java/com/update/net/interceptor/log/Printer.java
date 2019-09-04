package com.update.net.interceptor.log;

import android.util.Log;

/**
 * @author : liupu
 * date   : 2019/9/4
 * desc   : 日志打印帮助类
 * github : https://github.com/CodeLiuPu/
 */
public class Printer {
    private Level level;
    private String tag;

    private Printer(Builder builder) {
        this.level = builder.level;
        this.tag = builder.tag;
    }

    private void log(String msg) {
        switch (level) {
            case DEBUG:
                Log.d(tag,msg);
                break;
            case VERBOSE:
                Log.v(tag,msg);
                break;
            case INFO:
                Log.i(tag,msg);
                break;
            case WARN:
                Log.w(tag,msg);
                break;
            case ERROR:
                Log.e(tag,msg);
                break;
        }
    }

    public static class Builder {
        private Level level = Level.INFO;
        private String tag = "Log_default";

        public Builder logLevel(Level level) {
            this.level = level;
            return this;
        }

        public Builder tag(String tag) {
            this.tag = tag;
            return this;
        }

        public Printer build() {
            return new Printer(this);
        }
    }

}
