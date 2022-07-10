package com.example.newapplocation.data.source;

import com.example.newapplocation.data.db.AppDatabaseManager;
import com.example.newapplocation.data.entities.UserEntity;
import com.example.newapplocation.data.entities.UserEntityDao;

import java.util.List;

public class UserDataSource {
    private final UserEntityDao mDao;

    public UserDataSource(AppDatabaseManager databaseManager) {
        mDao = databaseManager.newSession().getUserEntityDao();
    }

    public void save(UserEntity user) {
        mDao.insertOrReplace(user);
    }

    public void remove(UserEntity userEntity) {
        mDao.delete(userEntity);
    }

    public UserEntity loadUser() {
        List<UserEntity> userEntities = mDao.loadAll();
        if (userEntities.size() == 1) {
            return userEntities.get(0);
        } else {
            mDao.deleteAll();
        }
        return null;
    }

    public void removeAll() {
        mDao.deleteAll();
    }
}
