package com.update.module_base.net;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * @author : liupu
 *  date   : 2019/4/20
 *  desc   :
 */
public interface BaseApiService {

    @FormUrlEncoded
    @POST("/post")
    Observable<String> post(@Field("token") String token);

    @GET("/get")
    Observable<String> get(
            @Header("token") String token,
            @Query("status") String status);
}