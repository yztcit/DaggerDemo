package com.apple_chen.daggerdemo.dagger.moudle;

import com.apple_chen.daggerdemo.bean.TestBean;
import com.apple_chen.daggerdemo.presenter.DaggerPresenter;
import com.apple_chen.daggerdemo.ui.activity.DaggerActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    private DaggerActivity mActivity;

    public ActivityModule(DaggerActivity daggerActivity) {
        mActivity = daggerActivity;
    }

    @Provides
    public DaggerActivity provideDaggerActivity() {
        return mActivity;
    }

    @Provides
    public TestBean provideTestBean() {
        long timeMillis = System.currentTimeMillis();
        SimpleDateFormat format = new SimpleDateFormat(
                "yyyy年MM月dd日 HH:mm:ss",
                Locale.CHINESE);
        Date date = new Date(timeMillis);
        String dateStr = format.format(date);
        return new TestBean(dateStr, "Just a simple demo!");
    }

    @Provides
    public DaggerPresenter provideDaggerPresenter(DaggerActivity daggerActivity, TestBean bean) {
        return new DaggerPresenter(daggerActivity, bean);
    }
}
