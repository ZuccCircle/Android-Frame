package com.zucc.circle.circleapp.common.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;

public class MyViewExample3 extends RecyclerView implements View.OnTouchListener{

    public MyViewExample3(Context context) {
        super(context);

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }
}
