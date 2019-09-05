package com.update.pmvp.ui.main.model;

import com.update.net.response.BaseResult;
import com.update.pmvp.net.HttpManager;
import com.update.pmvp.ui.main.contract.MainContract;

import io.reactivex.Observable;

/**
 * @author : liupu
 * date   : 2019/4/19
 * desc   :
 * github : https://github.com/CodeLiuPu/
 */
public class MainModel implements MainContract.Model {
    @Override
    public Observable<BaseResult<String>> loadData() {
        return  HttpManager.service().get();
    }

}
