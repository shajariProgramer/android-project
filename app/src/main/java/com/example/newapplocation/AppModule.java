package com.example.newapplocation;

import android.content.Context;
import android.os.Environment;

import java.io.File;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private final OpenSourceApp mApplication;

    AppModule(OpenSourceApp application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    OpenSourceApp provideApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return mApplication;
    }

    @Provides
    @Singleton
    @Named("AppPath")
    String provideAppPath(Context context) {
        File appDir = new File(Environment.getExternalStorageDirectory(), "Erp");
        if (appDir.exists()) {
            return appDir.getAbsolutePath();
        }
        if (appDir.mkdir()) {
            return appDir.getAbsolutePath();
        }
        return context.getExternalFilesDir(null).getAbsolutePath();
    }
}
