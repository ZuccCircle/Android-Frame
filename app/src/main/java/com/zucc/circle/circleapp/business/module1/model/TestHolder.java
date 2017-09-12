package com.zucc.circle.circleapp.business.module1.model;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.zucc.circle.circleapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TestHolder extends RecyclerView.ViewHolder{
    @BindView(R.id.tv_title)
    public TextView tvTitle;
    public TestHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
