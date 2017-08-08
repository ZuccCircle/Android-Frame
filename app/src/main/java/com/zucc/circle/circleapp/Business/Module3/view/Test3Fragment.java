package com.zucc.circle.circleapp.Business.Module3.view;



import android.support.v7.widget.LinearLayoutManager;

import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.zucc.circle.circleapp.Business.Module3.adapter.TestAdapter;
import com.zucc.circle.circleapp.Business.Module3.contract.TestContract;
import com.zucc.circle.circleapp.Business.Module3.model.TestBean;
import com.zucc.circle.circleapp.Business.Module3.model.TestModelImp;
import com.zucc.circle.circleapp.Business.Module3.presenter.TestPresenter;
import com.zucc.circle.circleapp.Common.Base.BaseFragment;
import com.zucc.circle.circleapp.R;

import java.util.ArrayList;

import butterknife.BindView;

public class Test3Fragment extends BaseFragment<TestPresenter> implements TestContract.View {
    @BindView(R.id.rv_test)
    LRecyclerView rvTest;

    TestAdapter testAdapter;
    LRecyclerViewAdapter lRecyclerViewAdapter;
    @Override
    public int getLayoutId() {
        return R.layout.fragment_test3;
    }

    @Override
    protected void initView() {
        //初始化
        ArrayList<TestBean> list = new ArrayList<>();
        for(int i = 0;i < 5; ++i) {
            list.add(new TestBean("标题" + i));
        }
        testAdapter = new TestAdapter(mContext);
        testAdapter.setDataList(list);
        lRecyclerViewAdapter = new LRecyclerViewAdapter(testAdapter);
        rvTest.setAdapter(lRecyclerViewAdapter);
        rvTest.setLayoutManager(new LinearLayoutManager(mContext));
    }

    @Override
    protected TestPresenter initPresenter() {
        return new TestPresenter(this, new TestModelImp());
    }

    @Override
    public void showList() {
        //View层更新/显示数据
    }
}
