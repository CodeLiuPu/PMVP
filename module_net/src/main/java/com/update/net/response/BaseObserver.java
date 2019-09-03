package com.update.net.response;


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
