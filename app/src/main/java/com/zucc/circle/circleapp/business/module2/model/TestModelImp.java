package com.zucc.circle.circleapp.business.module2.model;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.convert.StringConvert;
import com.lzy.okgo.model.Response;
import com.lzy.okrx2.adapter.ObservableResponse;
import com.zucc.circle.circleapp.api.ContantUrl;
import com.zucc.circle.circleapp.business.module3.contract.TestContract;

import io.reactivex.Observable;

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
