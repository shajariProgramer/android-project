package com.example.newapplocation.data.db;

import com.example.newapplocation.BuildConfig;
import com.example.newapplocation.data.entities.DaoMaster;
import com.example.newapplocation.data.entities.DaoSession;

import org.greenrobot.greendao.query.QueryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AppDatabaseManager implements DatabaseManager<DaoSession> {
    private static Logger Log = LoggerFactory.getLogger(DatabaseManager.class.getSimpleName());
    private DaoMaster appDaoMaster;
    private final DatabaseUpgradeHelper mDatabaseUpgradeHelper;

    public AppDatabaseManager(DatabaseUpgradeHelper databaseUpgradeHelper) {
        QueryBuilder.LOG_SQL = BuildConfig.LOQ_SQL;
        QueryBuilder.LOG_VALUES = BuildConfig.LOQ_VALUES;
        mDatabaseUpgradeHelper = databaseUpgradeHelper;
    }

    public void init() {
        appDaoMaster = new DaoMaster(mDatabaseUpgradeHelper.getWritableDatabase());
    }

    public void destroy() {
        try {
            if (appDaoMaster != null) {
                appDaoMaster.getDatabase().close();
                appDaoMaster = null;
            }

            if (mDatabaseUpgradeHelper != null) {
                mDatabaseUpgradeHelper.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public DaoSession newSession() {
        if (appDaoMaster == null) {
            Log.warn("AppDaoMaster is null!");
            init();
        }
        try {
            return appDaoMaster.newSession();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
            init();
            return appDaoMaster.newSession();
        }
    }
}
