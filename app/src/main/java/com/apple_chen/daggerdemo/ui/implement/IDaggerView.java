package com.apple_chen.daggerdemo.ui.implement;

import com.apple_chen.daggerdemo.bean.TaobaoIPLocationInfo;

public interface IDaggerView {
    void showTips(String... tips);

    void showLocationInfo(TaobaoIPLocationInfo taobaoIPLocationInfo);

    void showError(String message);
}
