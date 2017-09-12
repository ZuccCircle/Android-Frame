package com.zucc.circle.circleapp.business.module2.presenter;

import com.lzy.okgo.model.Response;
import com.zucc.circle.circleapp.business.module3.contract.TestContract;
import com.zucc.circle.circleapp.business.module3.model.TestModelImp;
import com.zucc.circle.circleapp.business.module3.view.Test3Fragment;
import com.zucc.circle.circleapp.common.base.BasePresenter;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class TestPresenter extends BasePresenter<Test3Fragment, TestModelImp> implements TestContract.Presenter{
    public TestPresenter(Test3Fragment mView, TestModelImp mModel) {
        super(mView, mModel);
    }

    @Override
    public void getList() {
        Observable observable = mModel.getList();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Response<String>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(@NonNull Response<String> stringResponse) {
                        //数据处理,调用View层方法
                        mView.showList();
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
