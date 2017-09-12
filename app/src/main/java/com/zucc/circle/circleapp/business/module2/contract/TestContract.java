package com.zucc.circle.circleapp.business.module2.contract;

import com.lzy.okgo.model.Response;
import com.zucc.circle.circleapp.common.base.BaseModel;
import com.zucc.circle.circleapp.common.base.BaseView;

import io.reactivex.Observable;

public class TestContract {
    public interface View extends BaseView {
        void showList();
    }
    public interface Presenter {
        void getList();
    }
    public interface Model extends BaseModel {
        Observable<Response<String>> getList();
    }
}
