package com.example.newapplocation.core.base;


import static com.example.newapplocation.core.base.BaseActivity.IS_FEATURES_DISCOVERED;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.newapplocation.R;

import org.acra.ACRA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * کلیه دیالوگ فرگمنت ها می بایست از این کلاس مشتق شوند.
 * این کلاس دارای لاگر می باشد
 */

public abstract class BaseDialogFragment<T extends BasePresenter> extends DialogFragment
        implements BaseView {
    protected final Logger Log;
    protected Unbinder mUnBinder;
    protected SharedPreferences mSharedPreferences;
    private T mPresenter;
    @BindView(R.id.progress_view)
    View mWaitingView;

    public BaseDialogFragment() {
        Log = LoggerFactory.getLogger(this.getClass().getSimpleName());
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupArguments();
        setupComponent();
        mSharedPreferences = getActivity().getSharedPreferences(this.getClass().getSimpleName(), Context.MODE_PRIVATE);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = new Dialog(getActivity(), R.style.AppTheme_Dialog);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().getAttributes().windowAnimations = R.style.SwingDialogAnimation;
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        return dialog;
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

    protected void discoverFeatures() {
    }

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

    protected abstract int contentView();

    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showWaiting(boolean status) {
        mWaitingView.setVisibility(status ? View.VISIBLE : View.GONE);
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
}
