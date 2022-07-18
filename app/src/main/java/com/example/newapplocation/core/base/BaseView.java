package com.example.newapplocation.core.base;

public interface BaseView {

    void showWaiting(boolean b);

    void showErrorMessage(String message);

    void showRequestOtpDialog();

    void showFeatureDiscovery();

    void makeFeatureDiscoveryFalse();
}
