package com.zucc.circle.circleapp.Application;

import android.app.Application;

import com.mazouri.tools.Tools;


/**
 * Created by 圆圈 on 2017-08-01.
 */

public class MyApplication extends Application {
    public void onCreate() {
        super.onCreate();
        //初始化工具
        Tools.init(this);
    }
}
