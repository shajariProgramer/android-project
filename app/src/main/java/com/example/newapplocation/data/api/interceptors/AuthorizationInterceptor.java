package com.example.newapplocation.data.api.interceptors;

import androidx.multidex.BuildConfig;

import com.example.newapplocation.core.EventBus;
import com.example.newapplocation.data.api.events.AccessDeniedEvent;
import com.example.newapplocation.data.api.events.OtpRequiredEvent;
import com.example.newapplocation.data.api.param.RegisterDeviceParams;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;


public class AuthorizationInterceptor implements Interceptor {

    private String mToken = "";
    private String mUserId = "";
    private String mOTP = "";
    private String mSystemChartId = "-1";
    private boolean mIsHeadersAdded = false;
    private RegisterDeviceParams mDeviceInfo;

    @Override
    public Response intercept(Chain chain) throws IOException {

        JSONObject jsonObject = new JSONObject();
        if (mDeviceInfo != null) {
            try {
                jsonObject.put("manufacturer", mDeviceInfo.getManufacturer());
                jsonObject.put("model", mDeviceInfo.getModel());
                jsonObject.put("sdk", mDeviceInfo.getSdk());
                jsonObject.put("serial", mDeviceInfo.getSerial());
                jsonObject.put("appVersion", BuildConfig.VERSION_CODE);
                jsonObject.put("devicePushNotificationId", mDeviceInfo.getDevicePushNotificationId());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        Request original = chain.request();
        if (mIsHeadersAdded) {
            // Request customization: add request headers
            Request.Builder requestBuilder = original.newBuilder()
                    .header("x-key", mUserId)
                    .header("x-device-type", "m")
                    .header("x-otp", mOTP)
                    .header("x-sc", mSystemChartId)
                    .header("x-access-token", mToken)
                    .header("X-MOBILE-DEVICE-INFO", jsonObject.toString()); // <-- this is the important line

            Request request = requestBuilder.build();
            Response response = chain.proceed(request);
            if (response.code() == 401) {
                EventBus.getInstance().send(new AccessDeniedEvent());
            }
            if (response.code() == 485) {
                EventBus.getInstance().send(new OtpRequiredEvent());
            }
            return response;
        }
        return chain.proceed(original);
    }

    public void setToken(String token) {
        mToken = token;
    }

    public void setUserId(String userId) {
        mUserId = userId;
    }

    public void setIsHeaderAdded(boolean addHeaders) {
        mIsHeadersAdded = addHeaders;
    }

    public void setOTP(String OTP) {
        mOTP = OTP;
    }

    public void setSystemChartId(String systemChartId) {
        mSystemChartId = systemChartId;
    }

    public void setDeviceInfo(RegisterDeviceParams mDeviceInfo) {
        this.mDeviceInfo = mDeviceInfo;
    }

    public void clear() {
        mUserId = "";
        mOTP = "";
        mSystemChartId = "-1";
        mToken = "";
        mDeviceInfo = null;
    }
}
