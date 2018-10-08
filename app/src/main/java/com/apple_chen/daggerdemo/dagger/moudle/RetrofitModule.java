package com.apple_chen.daggerdemo.dagger.moudle;

import com.apple_chen.daggerdemo.dagger.http.LocalRetrofit;
import com.apple_chen.daggerdemo.dagger.http.TaoBaoRetrofit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

@Module
public class RetrofitModule {

    @Singleton
    @Provides
    public LocalRetrofit provideLocalRetrofit(@Named("default") OkHttpClient okHttpClient) {
        return new LocalRetrofit(okHttpClient);
    }

    @Singleton
    @Provides
    public TaoBaoRetrofit provideTaoBaoRetrofit(@Named("cache") OkHttpClient okHttpClient) {
        return new TaoBaoRetrofit(okHttpClient);
    }
}
