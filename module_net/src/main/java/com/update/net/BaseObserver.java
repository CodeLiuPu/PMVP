package com.update.net;


import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


public abstract class BaseObserver<T extends BaseResult> implements Observer<T>, BaseCallbacks<T> {


    @Override
    public void onSubscribe(Disposable d) {
        onNetStart();
    }

    @Override
    public void onComplete() {
        onNetFinish();
    }

    @Override
    public void onNext(T value) {
//        if (TextUtils.equals(BaseModel.STATE_SUCCESS,value.getRspCode())) {
//            onSuccess(value);
//        } else {
//            onException(value);
//        }
    }

    @Override
    public void onError(Throwable e) {
        onNetError(e);
    }

}
