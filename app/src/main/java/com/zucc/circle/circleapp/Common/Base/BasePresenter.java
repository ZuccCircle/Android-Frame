package com.zucc.circle.circleapp.Common.Base;



import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by 圆圈 on 2017-08-04.
 */

public abstract class BasePresenter<T extends BaseView, M extends  BaseModel> {
    public T mView;
    public M mModel;
    CompositeDisposable compositeDisposable;
    public BasePresenter(T mView, M mModel) {
        this.mView = mView;
        this.mModel = mModel;
    }
    public void onDestroy() {
        unSubscribe();
        mView = null;

    }
    public void addDisposable(Disposable disposable) {
        if(compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(disposable);
    }
    public void unSubscribe() {
        if(compositeDisposable != null) {
            compositeDisposable.dispose();
        }
    }
}
