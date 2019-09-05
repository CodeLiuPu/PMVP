package com.update.pmvp.net;

import com.update.net.response.BaseResult;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * @author : liupu
 * date   : 2019/8/23
 * desc   :
 * github : https://github.com/CodeLiuPu/
 */
public interface HttpService {
    @GET(HttpURL.HTTP_GET)
    Observable<BaseResult<String>> get();
}
