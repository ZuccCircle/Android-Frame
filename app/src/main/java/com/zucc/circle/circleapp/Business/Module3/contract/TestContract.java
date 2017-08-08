package com.zucc.circle.circleapp.Business.Module3.contract;

import com.lzy.okgo.model.Response;
import com.zucc.circle.circleapp.Common.Base.BaseModel;
import com.zucc.circle.circleapp.Common.Base.BaseView;

import io.reactivex.Observable;

/**
 * Created by 圆圈 on 2017-08-04.
 */

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
