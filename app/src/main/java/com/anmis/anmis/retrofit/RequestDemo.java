package com.anmis.anmis.retrofit;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2016/10/28.
 */

public interface RequestDemo {

    @POST("content/ads/getList.json")
    Call<String> getString(@Query("type") String type);

}
