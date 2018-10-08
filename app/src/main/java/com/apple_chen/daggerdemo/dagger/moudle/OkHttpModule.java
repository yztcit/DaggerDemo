package com.apple_chen.daggerdemo.dagger.moudle;

import android.text.TextUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

@Module
public class OkHttpModule {

    @Singleton
    @Provides
    @Named("cache")
    public OkHttpClient provideAutoCacheOkHttpClient(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        Interceptor cacheInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Response response = chain.proceed(request);

                String cacheControl = request.cacheControl().toString();
                if (TextUtils.isEmpty(cacheControl)) {
                    cacheControl = "public, max-age=" + 3600 * 6 + " ,max-stale=2419200";
                }
                return response.newBuilder()
                        .header("Cache-Control", cacheControl)
                        .removeHeader("Pragma")
                        .build();
            }
        };
        return new OkHttpClient.Builder()
                .addNetworkInterceptor(interceptor)
                .addNetworkInterceptor(cacheInterceptor)
                .retryOnConnectionFailure(true)
                .connectTimeout(10, TimeUnit.SECONDS)
                .build();
    }

    @Singleton
    @Provides
    @Named("default")
    public OkHttpClient provideOkHttpClient(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder()
                .addNetworkInterceptor(interceptor)
                .retryOnConnectionFailure(true)
                .connectTimeout(10, TimeUnit.SECONDS)
                .build();
    }

}
