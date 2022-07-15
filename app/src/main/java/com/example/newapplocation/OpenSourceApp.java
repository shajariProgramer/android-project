package com.example.newapplocation;

import android.app.Application;
import android.content.Context;

import androidx.multidex.MultiDex;

import com.example.newapplocation.data.entities.PersonEntity;
import com.facebook.drawee.backends.pipeline.Fresco;

import org.acra.ACRA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.android.LogcatAppender;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.FileAppender;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class OpenSourceApp extends Application {
    public static final String APP_PREFERENCE = "oe_preferences";
    public static final String DEVICE_ID = "oe_device_id";
    public static final String VERSION_PATH = "oe_version_path";
    public static final String SERVER_URL = "oe_server_url";
    private Logger Log = LoggerFactory.getLogger(OpenSourceApp.class.getSimpleName());
    public static final int ANIMATION_DURATION = 400;

    private AppComponent mAppComponent;
    private UserComponent mUserComponent;

    public static OpenSourceApp get(Context context) {
        return (OpenSourceApp) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);
        Fresco.initialize(this);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/IRANSansMobile.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build());

        configureLogbackDirectly();

//        mAppComponent = DaggerAppComponent.builder()
//                .appModule(new AppModule(this))
//                .dataModule(new DataModule())
//                .apiModule(new ApiModule(BuildConfig.BASE_URL))
//                .domainModule(new DomainModule())
//                .build();


    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        ACRA.init(this);
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

    public UserComponent createUserComponent(PersonEntity personEntity) {
        mUserComponent = mAppComponent.plus(new UserModule(personEntity));
        return mUserComponent;
    }

    public UserComponent getUserComponent() {
        return mUserComponent;
    }

    private void configureLogbackDirectly() {
        // reset the default mContext (which may already have been initialized)
        // since we want to reconfigure it
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        lc.reset();

        // setup FileAppender
        PatternLayoutEncoder encoder1 = new PatternLayoutEncoder();
        encoder1.setContext(lc);
        encoder1.setPattern("%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n");
        encoder1.start();

        String logPath = this.getFileStreamPath("app.log").getAbsolutePath();
        Log.debug(logPath);
        FileAppender<ILoggingEvent> fileAppender = new FileAppender<>();
        fileAppender.setContext(lc);
        fileAppender.setFile(logPath);
        fileAppender.setEncoder(encoder1);
        fileAppender.start();

        // setup LogcatAppender
        PatternLayoutEncoder encoder2 = new PatternLayoutEncoder();
        encoder2.setContext(lc);
        encoder2.setPattern("[%thread] %msg%n");
        encoder2.start();

        LogcatAppender logcatAppender = new LogcatAppender();
        logcatAppender.setContext(lc);
        logcatAppender.setEncoder(encoder2);
        logcatAppender.start();

        // add the newly created appenders to the root logger;
        // qualify Logger to disambiguate from org.slf4j.Logger
        ch.qos.logback.classic.Logger root = (ch.qos.logback.classic.Logger)
                LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
        root.addAppender(fileAppender);
        root.addAppender(logcatAppender);
    }
}
