package com.example.newapplocation.core.base;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;

import com.example.newapplocation.core.EventBus;
import com.example.newapplocation.data.api.ErrorParser;
import com.example.newapplocation.data.api.events.OTPRegisteredEvent;
import com.example.newapplocation.data.api.events.OtpRequiredEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;


public abstract class BasePresenter<T extends BaseView> implements IPresenter {

    protected final T mView;
    protected final Logger Log;
    protected final ErrorParser mErrorParser;
    protected CompositeDisposable mSubscriptions = new CompositeDisposable();
    protected CompositeDisposable mDestroySubscriptions = new CompositeDisposable();

    protected BasePresenter(T view, ErrorParser errorParser) {
        mView = view;
        mErrorParser = errorParser;
        Log = LoggerFactory.getLogger(this.getClass());

        EventBus
                .getInstance()
                .toObservable()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(@NonNull Object o) throws Exception {
                        if (o instanceof OtpRequiredEvent) {
                            mView.showRequestOtpDialog();
                        }
                        if (o instanceof OTPRegisteredEvent) {
                            onOtpRegistered();
                        }
                    }
                });
    }

    @CallSuper
    @Override
    public void unSubscribe() {
        mSubscriptions.clear();
    }


    @CallSuper
    @Override
    public void unSubscribeOnDestroy() {
        mDestroySubscriptions.clear();
    }

    protected void showThrowableError(@NonNull Throwable e) {
        mView.showErrorMessage(mErrorParser.parseError(e).message());
    }

    @Override
    public void onOtpRegistered() {
    }

}
