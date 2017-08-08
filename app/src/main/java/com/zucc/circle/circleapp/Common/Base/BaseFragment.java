package com.zucc.circle.circleapp.Common.Base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by 圆圈 on 2017-08-04.
 */

public abstract class BaseFragment<T extends  BasePresenter> extends Fragment {
    protected Context mContext;
    protected View mRootView;
    protected T mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = (BaseActivity) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(getLayoutId(), container, false);
        ButterKnife.bind(this, mRootView);
        mPresenter = initPresenter();
        initView();
        return mRootView;
    }
    public abstract int getLayoutId();

    protected abstract void initView();

    protected abstract T initPresenter();


}
