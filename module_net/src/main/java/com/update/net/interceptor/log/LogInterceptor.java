/*
 * Copyright (C) 2015 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.update.net.interceptor.log;

import java.io.IOException;
import java.nio.charset.Charset;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;


public final class LogInterceptor implements Interceptor {
    private static final Charset UTF8 = Charset.forName("UTF-8");
    private volatile Level level = Level.NONE;
    private final Logger logger = Logger.DEFAULT;

    private LogInterceptor(Builder builder) {
        this.level = builder.level;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        // 如果是 NONE 则直接返回 不打印日志
        if (level == Level.NONE) {
            return chain.proceed(request);
        }

        boolean logBody = level == Level.BODY;
        boolean logHeaders = logBody || level == Level.HEADERS;

        Response response;
        try {
            response = chain.proceed(request);
        } catch (Exception e) {
            throw e;
        }


        return response;
    }

    public static class Builder {
        Level level = Level.NONE;

        public Builder logLevel(Level level) {
            this.level = level;
            return this;
        }

        public LogInterceptor build() {
            return new LogInterceptor(this);
        }
    }
}
