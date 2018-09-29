package com.apple_chen.daggerdemo.dagger.component;

import com.apple_chen.daggerdemo.dagger.moudle.ActivityModule;
import com.apple_chen.daggerdemo.ui.activity.DaggerActivity;

import dagger.Component;

@Component(modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(DaggerActivity activity);
}
