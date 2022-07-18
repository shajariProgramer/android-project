package com.example.newapplocation.core.base;

public interface IPresenter {
    void subscribe();

    void unSubscribe();

    void unSubscribeOnDestroy();

    void onOtpRegistered();
}
