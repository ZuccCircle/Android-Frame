package com.zucc.circle.circleapp.Business.Module3.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zucc.circle.circleapp.Business.Module3.holder.TestHolder;
import com.zucc.circle.circleapp.Business.Module3.model.TestBean;
import com.zucc.circle.circleapp.Common.Base.BaseAdapter;
import com.zucc.circle.circleapp.R;

/**
 * Created by 圆圈 on 2017-08-08.
 */

public class TestAdapter extends BaseAdapter<TestBean>{
    public TestAdapter(Context mContext) {
        super(mContext);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        RecyclerView.ViewHolder holder;
        view = LayoutInflater.from(mContext).inflate(R.layout.item_test, parent, false);
        holder = new TestHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        TestBean testBean = mDataList.get(position);
        TestHolder testHolder = (TestHolder) holder;
        setData(testHolder, position, testBean);
    }
    private void setData(TestHolder testHolder, final int position, final TestBean testBean) {
        testHolder.tvTitle.setText(testBean.getTitle());
    }

}