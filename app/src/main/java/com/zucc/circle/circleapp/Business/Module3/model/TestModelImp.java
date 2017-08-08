package com.zucc.circle.circleapp.Business.Module3.model;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.convert.StringConvert;
import com.lzy.okgo.model.Response;
import com.lzy.okrx2.adapter.ObservableResponse;
import com.zucc.circle.circleapp.Api.ContantUrl;
import com.zucc.circle.circleapp.Business.Module3.contract.TestContract;

import io.reactivex.Observable;

/**
 * Created by 圆圈 on 2017-08-04.
 */

public class TestModelImp implements TestContract.Model{

    @Override
    public Observable<Response<String>> getList() {
        Observable<Response<String>> observable = OkGo.<String>post(ContantUrl.BASE_URL)
                .headers("aaa", "111")
                .params("bbb", "222")
                .converter(new StringConvert())
                .adapt(new ObservableResponse<String>());
        return observable;
    }
}
