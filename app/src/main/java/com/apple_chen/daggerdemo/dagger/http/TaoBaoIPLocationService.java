package com.apple_chen.daggerdemo.dagger.http;

import com.apple_chen.daggerdemo.bean.TaobaoIPLocationInfo;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface TaoBaoIPLocationService {
    @GET("/service/getIpInfo2.php")
    Observable<TaobaoIPLocationInfo> getIPInfo(@Query("ip") String ip);
}
