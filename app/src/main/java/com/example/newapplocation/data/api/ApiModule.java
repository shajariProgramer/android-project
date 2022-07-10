package com.example.newapplocation.data.api;

import android.content.Context;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiModule {

    private final String mBaseUrl;

    public ApiModule(String baseUrl) {
        mBaseUrl = baseUrl;
    }

//    @Provides
//    @Singleton
//    AuthorizationInterceptor provideAuthorizationInterceptor() {
//        return new AuthorizationInterceptor();
//    }
//
//    @Provides
//    @Singleton
//    HostSelectionInterceptor provideHostSelectionInterceptor() {
//        return new HostSelectionInterceptor();
//    }
//
//    @Provides
//    @Singleton
//    OkHttpClient provideHttpClient(AuthorizationInterceptor authorizationInterceptor,
//                                   HostSelectionInterceptor hostSelectionInterceptor) {
//        final OkHttpClient.Builder builder = new OkHttpClient.Builder();
//        builder.readTimeout(BuildConfig.READ_TIMEOUT, java.util.concurrent.TimeUnit.SECONDS);
//        builder.connectTimeout(BuildConfig.CONNECT_TIMEOUT, java.util.concurrent.TimeUnit.SECONDS);
//        builder.writeTimeout(BuildConfig.WRITE_TIMEOUT, java.util.concurrent.TimeUnit.SECONDS);
//        if (BuildConfig.DEBUG) {
//            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
//            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//            builder.addInterceptor(loggingInterceptor);
//        }
//        builder.addInterceptor(authorizationInterceptor);
//        builder.addInterceptor(hostSelectionInterceptor);
//        return builder.build();
//    }
//
//    @Provides
//    @Singleton
//    Retrofit provideRestAdapter(OkHttpClient httpClient, Gson gson) {
//        Retrofit.Builder builder = new Retrofit.Builder();
//        builder.client(httpClient)
//                .baseUrl(mBaseUrl)
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create(gson));
//        return builder.build();
//    }
//
//    @Provides
//    @Singleton
//    Gson provideGson() {
//        ExclusionStrategy exclusionStrategy = new ExclusionStrategy() {
//            @Override
//            public boolean shouldSkipField(FieldAttributes f) {
//                return f.getAnnotation(Exclude.class) != null;
//            }
//
//            @Override
//            public boolean shouldSkipClass(Class<?> clazz) {
//                return false;
//            }
//        };
//        GsonBuilder builder = new GsonBuilder();
//        builder.setExclusionStrategies(exclusionStrategy);
//        return builder.create();
//    }
//
//    @Provides
//    @Singleton
//    ApiService provideApiService(Retrofit restAdapter) {
//        return restAdapter.create(ApiService.class);
//    }
//
//    @Provides
//    @Singleton
//    PazhService providePazhService(Gson gson) {
//        final OkHttpClient.Builder httpBuilder = new OkHttpClient.Builder();
//        httpBuilder.readTimeout(BuildConfig.READ_TIMEOUT, java.util.concurrent.TimeUnit.SECONDS);
//        httpBuilder.connectTimeout(BuildConfig.CONNECT_TIMEOUT, java.util.concurrent.TimeUnit.SECONDS);
//        httpBuilder.writeTimeout(BuildConfig.WRITE_TIMEOUT, java.util.concurrent.TimeUnit.SECONDS);
//        if (BuildConfig.DEBUG) {
//            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
//            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//            httpBuilder.addInterceptor(loggingInterceptor);
//        }
//        httpBuilder.build();
//        Retrofit.Builder builder = new Retrofit.Builder();
//        builder.client(httpBuilder.build())
//                .baseUrl(mBaseUrl)
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create(gson));
//        return builder.build().create(PazhService.class);
//    }
//
//    @Provides
//    @Singleton
//    ErrorParser provideErrorParser(Context context, Retrofit retrofit) {
//        return new ErrorParser(context, retrofit);
//    }
}
