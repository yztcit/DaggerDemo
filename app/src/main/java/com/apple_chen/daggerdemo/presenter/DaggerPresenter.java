package com.apple_chen.daggerdemo.presenter;

import com.apple_chen.daggerdemo.bean.TestBean;
import com.apple_chen.daggerdemo.ui.activity.DaggerActivity;

public class DaggerPresenter {
    private DaggerActivity mActivity;
    private TestBean mBean;

    public DaggerPresenter(DaggerActivity activity ,TestBean bean){
        mActivity = activity;
        mBean = bean;
    }

    public void showTips(){
        String tips = "Tips: " + mBean.getTestDate() +
                " --- " + mBean.getTestTip();
        mActivity.showTips(tips);
    }
}
