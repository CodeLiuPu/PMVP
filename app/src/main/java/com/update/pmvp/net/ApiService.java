package com.update.pmvp.net;

import com.update.module_base.net.BaseApiService;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * @author : liupu
 * date   : 2019/4/23
 * desc   :
 */
public interface ApiService extends BaseApiService {

    @GET("/get")
    Observable<String> getName(
            @Header("token") String token,
            @Query("status") String status);

}
