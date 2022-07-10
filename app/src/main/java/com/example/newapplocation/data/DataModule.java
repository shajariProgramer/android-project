package com.example.newapplocation.data;

import android.content.Context;

import com.example.newapplocation.data.db.AppDatabaseManager;
import com.example.newapplocation.data.db.DatabaseUpgradeHelper;
import com.example.newapplocation.data.source.CustomerDataSource;
import com.example.newapplocation.data.source.MenuDataSource;
import com.example.newapplocation.data.source.PersonDataSource;
import com.example.newapplocation.data.source.SettingDataSource;
import com.example.newapplocation.data.source.UserDataSource;

import java.io.File;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class DataModule {

    private static final String DATABASE = "DB_PATH_AND_NAME";
    private static final String APP_DB_NAME = "app.db";

    @Provides
    @Singleton
    CustomerDataSource provideCustomerDataSource(AppDatabaseManager databaseManager) {
        return new CustomerDataSource(databaseManager);
    }

    @Provides
    @Named(DATABASE)
    String provideDatabaseName(Context context) {

        File path = new File(context.getFilesDir(), APP_DB_NAME);
        return path.getAbsolutePath();
    }

    @Provides
    @Singleton
    DatabaseUpgradeHelper provideDatabaseUpgradeHelper(Context context,
                                                       @Named(DATABASE) String dbName) {
        return new DatabaseUpgradeHelper(context, dbName);
    }

    @Provides
    @Singleton
    AppDatabaseManager provideAppDataBaseManager(DatabaseUpgradeHelper databaseUpgradeHelper) {
        return new AppDatabaseManager(databaseUpgradeHelper);
    }


    @Provides
    @Singleton
    UserDataSource provideUserDataSource(AppDatabaseManager databaseManager) {
        return new UserDataSource(databaseManager);
    }

    @Provides
    @Singleton
    SettingDataSource provideSettingDataSource(AppDatabaseManager appDatabaseManager) {
        return new SettingDataSource(appDatabaseManager);
    }

    @Provides
    @Singleton
    MenuDataSource provideMenuDataSource(AppDatabaseManager appDatabaseManager) {
        return new MenuDataSource(appDatabaseManager);
    }


    @Provides
    @Singleton
    PersonDataSource providePersonDataSource(AppDatabaseManager appDatabaseManager){
        return new PersonDataSource(appDatabaseManager);
    }
}
