package com.zucc.circle.circleapp.common.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zucc.circle.circleapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyViewExample2 extends LinearLayout{

    @BindView(R.id.button)
    Button button;
    @BindView(R.id.textView2)
    TextView textView;
    public MyViewExample2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        View contentView = LayoutInflater.from(context).inflate(R.layout.my_title, this);
        //获取控件
        ButterKnife.bind(this, contentView);
    }
    public void setButtonListener(OnClickListener listener) {
        button.setOnClickListener(listener);
    }
    public void setTextContent(String title) {
        textView.setText(title);
    }
}
