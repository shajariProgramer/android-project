package com.example.newapplocation.data.api.interceptors;



import com.example.newapplocation.BuildConfig;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public final class HostSelectionInterceptor implements Interceptor {
    private String mUrl;

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        if (mUrl != null && !mUrl.equals("")) {
            String newUrl = request.url().toString();
            newUrl = newUrl.replace(BuildConfig.BASE_URL, mUrl);
            request = request.newBuilder()
                    .url(newUrl)
                    .build();
        }
        return chain.proceed(request);
    }

    public void setUrl(String url) {
        mUrl = url;
    }
}
