package com.apple_chen.daggerdemo.dagger.http;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class TaoBaoRetrofit {
    private static final String BASE_URL = "http://ip.taobao.com/";
    private static Retrofit retrofit;

    public TaoBaoRetrofit(OkHttpClient okHttpClient){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public  Retrofit getRetrofit() {
        return retrofit;
    }
}
