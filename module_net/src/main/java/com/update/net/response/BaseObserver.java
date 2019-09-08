package com.update.net.response;


import com.update.net.HttpStatusCode;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author : liupu
 * date   : 2019/8/23
 * desc   :
 * github : https://github.com/CodeLiuPu/
 */
public abstract class BaseObserver<T extends BaseResult> implements Observer<T>, BaseCallbacks<T> {

    @Override
    public void onSubscribe(Disposable d) {
        onRequestStart();
    }

    @Override
    public void onComplete() {
        onRequestFinish();
    }

    @Override
    public void onNext(T value) {
        if (HttpStatusCode.SUCCESS.equalsIgnoreCase(value.code)) {
            onSuccess(value);
        } else {
            onFail(value.code, value.message);
        }
    }

    @Override
    public void onError(Throwable e) {
        onRequestFinish();
        onFail("", e.getMessage());
    }

}
