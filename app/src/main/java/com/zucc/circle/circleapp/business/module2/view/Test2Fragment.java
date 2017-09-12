package com.zucc.circle.circleapp.business.module2.view;


import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.zucc.circle.circleapp.common.base.BaseFragment;
import com.zucc.circle.circleapp.common.base.BasePresenter;
import com.zucc.circle.circleapp.R;
import com.zucc.circle.circleapp.common.widget.MyViewExample2;

import butterknife.BindAnim;
import butterknife.BindView;


public class Test2Fragment extends BaseFragment {
    @BindView(R.id.myView2)
    MyViewExample2 myView2;
    @BindAnim(R.anim.myanimation)
    Animation animation;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_test2;
    }

    @Override
    protected void initView() {
        myView2.setButtonListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "点击了按钮", Toast.LENGTH_LONG).show();
                myView2.setTextContent("调用自定义方法改变文字");
            }
        });

        animation = AnimationUtils.loadAnimation(getContext(), R.anim.myanimation);
        myView2.startAnimation(animation);

    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

}
