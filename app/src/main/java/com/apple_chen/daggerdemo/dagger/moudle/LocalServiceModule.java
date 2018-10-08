package com.apple_chen.daggerdemo.dagger.moudle;

import com.apple_chen.daggerdemo.dagger.http.LocalRetrofit;
import com.apple_chen.daggerdemo.dagger.http.UserService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class LocalServiceModule {
    @Singleton
    @Provides
    public UserService provideUserService(LocalRetrofit retrofit){
        return retrofit.getRetrofit().create(UserService.class);
    }
}
