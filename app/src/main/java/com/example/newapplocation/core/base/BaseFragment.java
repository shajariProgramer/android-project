package com.example.newapplocation.core.base;


import static com.example.newapplocation.core.base.BaseActivity.IS_FEATURES_DISCOVERED;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.newapplocation.R;

import org.acra.ACRA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import pub.devrel.easypermissions.EasyPermissions;

public abstract class BaseFragment<T extends BasePresenter> extends Fragment
        implements BaseView {

    protected final Logger Log;
    protected Unbinder mUnBinder;
    protected SharedPreferences mSharedPreferences;
    private T mPresenter;

    @Nullable
    @BindView(R.id.progress_view)
    View mWaitingView;

    public BaseFragment() {
        Log = LoggerFactory.getLogger(this.getClass().getSimpleName());
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupArguments();
        setupComponent();
        mSharedPreferences = getActivity().getSharedPreferences(this.getClass().getSimpleName(), Context.MODE_PRIVATE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(contentView(), container, false);
        mUnBinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ACRA.getErrorReporter().putCustomData("systemObjectId", "0");
        getPresenter().unSubscribeOnDestroy();
        mUnBinder.unbind();
    }

    protected abstract void setupComponent();

    protected abstract void setupArguments();

    protected abstract int contentView();

    protected abstract void discoverFeatures();

    protected T getPresenter() {
        return mPresenter;
    }

    @Inject
    public void setPresenter(T presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onPause() {
        super.onPause();
        getPresenter().unSubscribe();
    }

    @Override
    public void onResume() {
        super.onResume();
        getPresenter().subscribe();
    }

    @Override
    public void showWaiting(boolean status) {
        mWaitingView.setVisibility(status ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showErrorMessage(String message) {

    }

    @Override
    public void showRequestOtpDialog() {

    }

    @Override
    public void showFeatureDiscovery() {
        if (!isFeaturesDiscovered()) {
            discoverFeatures();
        }
    }

    protected boolean isFeaturesDiscovered() {
        return mSharedPreferences.getBoolean(IS_FEATURES_DISCOVERED, false);
    }

    protected void onFeaturesDiscovered() {
        mSharedPreferences.edit().putBoolean(IS_FEATURES_DISCOVERED, true).apply();
    }

    @Override
    public void makeFeatureDiscoveryFalse() {
        mSharedPreferences.edit().putBoolean(IS_FEATURES_DISCOVERED, false).apply();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }
}
