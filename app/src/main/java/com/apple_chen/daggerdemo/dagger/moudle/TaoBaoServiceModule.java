package com.apple_chen.daggerdemo.dagger.moudle;

import com.apple_chen.daggerdemo.dagger.http.TaoBaoIPLocationService;
import com.apple_chen.daggerdemo.dagger.http.TaoBaoRetrofit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class TaoBaoServiceModule {
    @Singleton
    @Provides
    public TaoBaoIPLocationService provideTaoBaoIPService(TaoBaoRetrofit retrofit){
        return retrofit.getRetrofit().create(TaoBaoIPLocationService.class);
    }
}
