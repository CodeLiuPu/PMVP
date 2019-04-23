package com.update.pmvp.net;

import com.update.module_base.net.BaseRetrofitManager;

/**
 * @author : liupu
 * date   : 2019/4/23
 * desc   :
 */
public class RetrofitManager extends BaseRetrofitManager {

    //获取创建的服务对象
    public static ApiService createApi(){
        return createApi(ApiService.class);
    }

}
