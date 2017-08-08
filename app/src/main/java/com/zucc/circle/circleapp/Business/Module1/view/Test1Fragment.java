package com.zucc.circle.circleapp.Business.Module1.view;


import android.graphics.PorterDuff;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;

import com.zucc.circle.circleapp.Common.Base.BaseFragment;
import com.zucc.circle.circleapp.Common.Base.BasePresenter;
import com.zucc.circle.circleapp.R;
import com.zucc.circle.circleapp.Common.Widget.MyViewExample;
import butterknife.BindView;


public class Test1Fragment extends BaseFragment {
    @BindView(R.id.myView)
    MyViewExample myView;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_test1;
    }

    @Override
    protected void initView() {
        myView.setPorterDuffMode(PorterDuff.Mode.DARKEN);
        Animation animation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setDuration(2000);

        myView.startAnimation(animation);
    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }
}
