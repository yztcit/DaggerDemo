package com.apple_chen.daggerdemo.dagger.moudle;

import com.apple_chen.daggerdemo.bean.TestBean;
import com.apple_chen.daggerdemo.presenter.DaggerPresenter;
import com.apple_chen.daggerdemo.ui.implement.IDaggerView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private IDaggerView iDaggerView;

    public ActivityModule(IDaggerView iDaggerView) {
        this.iDaggerView = iDaggerView;
    }

    @Provides
    public IDaggerView provideView(){
        return iDaggerView;
    }

    @Provides
    public TestBean provideTestBean() {
        long timeMillis = System.currentTimeMillis();
        SimpleDateFormat format = new SimpleDateFormat(
                "yyyy年MM月dd日 HH:mm:ss",
                Locale.CHINA);
        Date date = new Date(timeMillis);
        String dateStr = format.format(date);
        return new TestBean(dateStr, "Just a simple demo!");
    }
}
