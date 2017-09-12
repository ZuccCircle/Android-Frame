package com.zucc.circle.circleapp.application;

import android.app.Application;

import com.mazouri.tools.Tools;

public class MyApplication extends Application {
    public void onCreate() {
        super.onCreate();
        //初始化工具
        Tools.init(this);
    }
}
