package com.example.newapplocation.data.db;


import org.greenrobot.greendao.AbstractDaoSession;

public interface DatabaseManager<T extends AbstractDaoSession> {
    void init();

    void destroy();

    T newSession();
}
