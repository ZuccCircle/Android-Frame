package com.zucc.circle.circleapp.Common.Util;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import java.util.ArrayList;

/**
 * author: chensen
 * date: 2017年03月23日15:04
 * desc:fragment切换控制器, 初始化时直接add全部fragment, 然后利用show和hide进行切换控制
 */

public class FragmentController {
    private int containerId;
    private FragmentManager fragmentManager;
    private ArrayList<Fragment> listFragments;


    public FragmentController(int containerId, FragmentManager fragmentManager, ArrayList<Fragment> listFragments) {
        this.containerId = containerId;
        this.fragmentManager = fragmentManager;
        this.listFragments = listFragments;
    }


    public void initFragment() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        for (int i = 0; i < listFragments.size(); i++) {
            transaction.add(containerId, listFragments.get(i), i + "");

        }
        transaction.commit();
    }

    public void showFragment(int position) {
        hideFragments();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.show(listFragments.get(position)).commit();

    }


    public void hideFragments() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        for (Fragment fragment : listFragments) {
            transaction.hide(fragment);
        }
        transaction.commit();
    }


}