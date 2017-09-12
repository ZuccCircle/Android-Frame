package com.zucc.circle.circleapp.business.module1.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.zucc.circle.circleapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TestHolder extends RecyclerView.ViewHolder{
    @BindView(R.id.tv_title)
    protected TextView tvTitle;
    protected TestHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
