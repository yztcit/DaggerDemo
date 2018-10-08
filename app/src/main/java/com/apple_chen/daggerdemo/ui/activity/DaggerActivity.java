package com.apple_chen.daggerdemo.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.apple_chen.daggerdemo.R;
import com.apple_chen.daggerdemo.bean.TaobaoIPLocationInfo;
import com.apple_chen.daggerdemo.dagger.component.DaggerActivityComponent;
import com.apple_chen.daggerdemo.dagger.moudle.ActivityModule;
import com.apple_chen.daggerdemo.presenter.DaggerPresenter;
import com.apple_chen.daggerdemo.ui.implement.IDaggerView;

import java.util.Arrays;

import javax.inject.Inject;


public class DaggerActivity extends AppCompatActivity implements IDaggerView,View.OnClickListener{
    private static final String TAG = "DaggerActivity";
    private TextView tvShow;
    private Button btnTest;

    @Inject
    DaggerPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger);
        initView();
        inject();
        initData();
    }

    private void inject() {
        DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .build().inject(this);
    }

    private void initData() {
        mPresenter.showTips();
        btnTest.setOnClickListener(this);
    }

    private void initView() {
        tvShow = findViewById(R.id.tv_tip);
        btnTest = findViewById(R.id.btn_test);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_test:
                mPresenter.ipTest();
                break;
        }
    }

    @Override
    public void showTips(String... tips) {
        tvShow.setText(Arrays.toString(tips));
    }

    @Override
    public void showLocationInfo(TaobaoIPLocationInfo taobaoIPLocationInfo) {
        StringBuilder info = new StringBuilder();
        info.append(String.format("定位城市：%s", taobaoIPLocationInfo.getData().getCity()));
        info.append(String.format("定位城市代码：%s", taobaoIPLocationInfo.getData().getCity_id()));
        info.append(String.format("地位地区IP：%s", taobaoIPLocationInfo.getData().getIp()));
        info.append(String.format("isp服务提供商：%s", taobaoIPLocationInfo.getData().getIsp()));

        tvShow.setText(info);
    }

    @Override
    public void showError(String message) {
        tvShow.setText(message);
        Log.e(TAG, message);
    }
}
