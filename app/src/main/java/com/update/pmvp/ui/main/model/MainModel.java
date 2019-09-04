package com.update.pmvp.ui.main.model;

import com.update.base.utils.log.LogUtil;
import com.update.net.scheduler.RxScheduler;
import com.update.pmvp.net.HttpManager;
import com.update.pmvp.ui.main.contract.MainContract;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author : liupu
 * date   : 2019/4/19
 * desc   :
 * github : https://github.com/CodeLiuPu/
 */
public class MainModel implements MainContract.Model {

    @Override
    public String loadData() {
        HttpManager.service().get().compose(RxScheduler.Obs_io_main())
                .subscribe(new Observer<String>() {

                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(String stringBaseResult) {
                        LogUtil.e("onNext " + stringBaseResult);
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtil.e("onError");
                    }

                    @Override
                    public void onComplete() {
                        LogUtil.e("onComplete");
                    }
                });
        return "Update";
    }

}
