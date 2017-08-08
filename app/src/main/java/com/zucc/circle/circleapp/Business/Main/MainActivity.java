package com.zucc.circle.circleapp.Business.Main;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;
import com.zucc.circle.circleapp.Common.Base.BaseActivity;
import com.zucc.circle.circleapp.Business.Module1.view.Test1Fragment;
import com.zucc.circle.circleapp.Business.Module2.view.Test2Fragment;
import com.zucc.circle.circleapp.Business.Module3.view.Test3Fragment;
import com.zucc.circle.circleapp.Common.Base.BasePresenter;
import com.zucc.circle.circleapp.Common.Util.FragmentController;
import com.zucc.circle.circleapp.R;

import java.util.ArrayList;

import butterknife.BindView;

public class MainActivity extends BaseActivity {
    @BindView(R.id.bottombar) BottomBar bottomBar;
    FragmentController fragmentController;
    ArrayList<Fragment> listFragment;
    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        listFragment = new ArrayList<>();
        listFragment.add(new Test1Fragment());
        listFragment.add(new Test2Fragment());
        listFragment.add(new Test3Fragment());
        fragmentController = new FragmentController(R.id.maincontent, getSupportFragmentManager(), listFragment);
        fragmentController.initFragment();
        fragmentController.showFragment(0);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                int curPosition = bottomBar.findPositionForTabWithId(tabId);
                fragmentController.showFragment(curPosition);
            }
        });
    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }
}
