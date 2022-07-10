package com.example.newapplocation.data.source;

import com.example.newapplocation.data.db.AppDatabaseManager;
import com.example.newapplocation.data.entities.PersonEntity;
import com.example.newapplocation.data.entities.PersonEntityDao;

public class PersonDataSource {
    private final PersonEntityDao mDao;

    public PersonDataSource(AppDatabaseManager appDatabaseManager) {
        this.mDao = appDatabaseManager.newSession().getPersonEntityDao();
    }

    public Long insertLoginData(PersonEntity personEntity) {
        long status = mDao.insertOrReplace(personEntity);
        return status;
    }

    public void updateUserAccount(PersonEntity personEntity) {
        personEntity.setToken(mDao.loadAll().get(0).getToken());
        mDao.insertOrReplace(personEntity);
    }

    public PersonEntity loadUser() {
        return mDao.loadAll().get(0);
    }
}
