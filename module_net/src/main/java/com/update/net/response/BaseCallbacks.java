package com.update.net.response;

import android.support.annotation.NonNull;

/**
 * @author : liupu
 * date   : 2019/8/23
 * desc   :
 * github : https://github.com/CodeLiuPu/
 */
public interface BaseCallbacks<T> {
    void onNetStart();

    void onNetFinish();

    void onSuccess(@NonNull T data);

    void onException(@NonNull T data);

    void onNetError(@NonNull Throwable e);
}
