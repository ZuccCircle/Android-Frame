package com.zucc.circle.circleapp.business.module1.view;


import android.util.Log;

import com.zucc.circle.circleapp.common.base.BaseFragment;
import com.zucc.circle.circleapp.common.base.BasePresenter;
import com.zucc.circle.circleapp.common.widget.LearnView;
import com.zucc.circle.circleapp.R;

import butterknife.BindView;
import me.panpf.sketch.Sketch;
import me.panpf.sketch.SketchImageView;
import me.panpf.sketch.request.DisplayOptions;
import me.panpf.sketch.request.DownloadOptions;
import me.panpf.sketch.request.LoadOptions;
import me.panpf.sketch.request.RequestLevel;
import me.panpf.sketch.zoom.ImageZoomer;


public class Test1Fragment extends BaseFragment {
		@BindView(R.id.iv_scale_test)
		SketchImageView ivScaleTest;

		ImageZoomer zoomer; // 控制缩放，旋转类
		DisplayOptions displayOptions;//控制显示策略
		DownloadOptions downloadOptions;//控制下载策略
		LoadOptions loadOptions;//控制加载策略

    @Override
    public int getLayoutId() {
        return R.layout.fragment_test1;
    }

    @Override
    protected void initView() {
		    ivScaleTest.displayImage("http://t.cn/RShdS1f");
		    ivScaleTest.setZoomEnabled(true);
		    displayOptions = new DisplayOptions();
		    displayOptions.setRequestLevel(RequestLevel.LOCAL);
		    ivScaleTest.setOptions(displayOptions);

//		    zoomer = new ImageZoomer(ivScaleTest);
//		    zoomer.zoom(3f, true);
    }


    @Override
    protected BasePresenter initPresenter() {
        return null;
    }
}
