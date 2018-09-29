package com.apple_chen.daggerdemo.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.apple_chen.daggerdemo.R;
import com.apple_chen.daggerdemo.dagger.component.DaggerActivityComponent;
import com.apple_chen.daggerdemo.dagger.moudle.ActivityModule;
import com.apple_chen.daggerdemo.presenter.DaggerPresenter;
import com.apple_chen.daggerdemo.ui.implement.IDaggerView;

import java.util.Arrays;

import javax.inject.Inject;


public class DaggerActivity extends AppCompatActivity implements IDaggerView{
    private TextView tvShow;

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
    }

    private void initView() {
        tvShow = findViewById(R.id.tv_tip);
    }

    @Override
    public void showTips(String... tips) {
        tvShow.setText(Arrays.toString(tips));
    }
}
