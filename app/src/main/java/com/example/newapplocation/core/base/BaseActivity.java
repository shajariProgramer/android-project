package com.example.newapplocation.core.base;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ViewUtils;

import com.example.newapplocation.R;

import org.acra.ACRA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import pub.devrel.easypermissions.EasyPermissions;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * کلیه اکتیویتی ها می بایست از این کلاس مشتق شوند.
 * این کلاس وظیفه تنظیم کردن فونت و لاگر را بر عهده دارد
 */
public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity
        implements BaseView {

    public static final String IS_FEATURES_DISCOVERED = "features_discovered";
    public static final String IS_FEATURES_DATE_DISCOVERED = "features_date_discovered";
    public static final String IS_FEATURES_SEARCH_DISCOVERED = "features_search_discovered";
    public static final String IS_FEATURES_ADD_WORK_REPORT_DISCOVERED = "features_add_work_report_discovered";
    public static final String IS_FEATURES_BOARD_SEARCH_DISCOVERED = "features_board_search_discovered";
    protected Logger Log;
    private T mPresenter;
    protected SharedPreferences mSharedPreferences;

    @BindView(R.id.progress_view)
    View mWaitingView;

    public BaseActivity() {
        Log = LoggerFactory.getLogger(this.getClass().getSimpleName());
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupWindowAnimations();
        setupArguments();
        setupActivityComponent();
        setContentView(contentView());
//        ViewUtils.forceRTLIfSupported(getWindow());
        ButterKnife.bind(this);

        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
            ab.setHomeAsUpIndicator(R.drawable.ic_arrow_right);
        }
        mSharedPreferences = getSharedPreferences(this.getClass().getSimpleName(), MODE_PRIVATE);
    }

    protected void setupWindowAnimations() {
    }

    protected abstract void setupActivityComponent();

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
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        super.onPause();
        getPresenter().unSubscribe();
    }

    @Override
    protected void onResume() {
        super.onResume();
        showFeatureDiscovery();
        getPresenter().subscribe();
    }

    @Override
    protected void onDestroy() {
        getPresenter().unSubscribeOnDestroy();
        ACRA.getErrorReporter().putCustomData("systemObjectId", "0");
        super.onDestroy();
    }

    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
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
//        SharedPreferences sharedPreferences = getSharedPreferences(DashboardActivity.class.getSimpleName(), MODE_PRIVATE);
//        sharedPreferences.edit().putBoolean(IS_FEATURES_DISCOVERED, false).apply();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }
}
