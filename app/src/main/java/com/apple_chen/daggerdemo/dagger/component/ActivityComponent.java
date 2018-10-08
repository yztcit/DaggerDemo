package com.apple_chen.daggerdemo.dagger.component;

import com.apple_chen.daggerdemo.dagger.moudle.ActivityModule;
import com.apple_chen.daggerdemo.dagger.moudle.LocalServiceModule;
import com.apple_chen.daggerdemo.dagger.moudle.OkHttpModule;
import com.apple_chen.daggerdemo.dagger.moudle.RetrofitModule;
import com.apple_chen.daggerdemo.dagger.moudle.TaoBaoServiceModule;
import com.apple_chen.daggerdemo.ui.activity.DaggerActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ActivityModule.class, OkHttpModule.class, RetrofitModule.class
        , LocalServiceModule.class, TaoBaoServiceModule.class})
public interface ActivityComponent {
    void inject(DaggerActivity activity);
}
