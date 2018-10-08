package com.apple_chen.daggerdemo.presenter;

import com.apple_chen.daggerdemo.bean.TaobaoIPLocationInfo;
import com.apple_chen.daggerdemo.bean.TestBean;
import com.apple_chen.daggerdemo.dagger.http.TaoBaoIPLocationService;
import com.apple_chen.daggerdemo.dagger.http.UserService;
import com.apple_chen.daggerdemo.ui.implement.IDaggerView;

import javax.inject.Inject;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class DaggerPresenter {
    private IDaggerView iDaggerView;
    private TestBean mBean;

    private final TaoBaoIPLocationService locationService;
    private final UserService userService;

    @Inject
    DaggerPresenter(IDaggerView iDaggerView, TestBean mBean,
                    TaoBaoIPLocationService locationService,
                    UserService userService) {
        this.iDaggerView = iDaggerView;
        this.mBean = mBean;
        this.locationService = locationService;
        this.userService = userService;
    }

    public void showTips(){
        String tips = "Tips: " + mBean.getTestDate() +
                " --- " + mBean.getTestTip();
        iDaggerView.showTips(tips);
    }

    public void ipTest(){
        locationService.getIPInfo("124.65.164.98")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<TaobaoIPLocationInfo>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        iDaggerView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(TaobaoIPLocationInfo taobaoIPLocationInfo) {
                        iDaggerView.showLocationInfo(taobaoIPLocationInfo);
                    }
                });
    }
}
