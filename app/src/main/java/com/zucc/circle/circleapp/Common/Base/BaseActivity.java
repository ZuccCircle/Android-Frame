package com.zucc.circle.circleapp.Common.Base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;


import butterknife.ButterKnife;

/**
 * Created by 圆圈 on 2017-08-01.
 */

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {
    protected Context mContext;
    protected T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        doBeforeSetContentView();
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        mContext = this;
        //创建Presenter
        mPresenter = initPresenter();
        initView();
    }
    //设置layout前配置
    private void doBeforeSetContentView() {
    }
    //获取布局文件
    public abstract int getLayoutId();

    //初始化view
    protected abstract void initView();

    //简单页面无需mvp就不用管此方法即可,完美兼容各种实际场景的变通
    protected abstract T initPresenter();

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

}
