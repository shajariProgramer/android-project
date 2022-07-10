package com.example.newapplocation.data.source;

import com.example.newapplocation.data.db.AppDatabaseManager;
import com.example.newapplocation.data.entities.SettingEntity;
import com.example.newapplocation.data.entities.SettingEntityDao;

import java.util.List;



public class SettingDataSource {
    private final SettingEntityDao mDao;

    public SettingDataSource(AppDatabaseManager databaseManager) {
        mDao = databaseManager.newSession().getSettingEntityDao();
    }

    public long add(String key, String value, Long userId) {
        SettingEntity settingEntity = mDao.queryBuilder().where(SettingEntityDao.Properties.Key.eq(key),
                SettingEntityDao.Properties.UserId.eq(userId)).unique();
        long result;
        if (settingEntity == null) {
            SettingEntity entity = new SettingEntity();
            entity.setValue(value);
            entity.setKey(key);
            entity.setUserId(userId);
            mDao.insert(entity);
            result = entity.getId();
        } else {
            settingEntity.setValue(value);
            mDao.update(settingEntity);
            result = settingEntity.getId();
        }
        return result;
    }

    public SettingEntity loadSetting(String key, Long userId) {
        return mDao.queryBuilder().where(SettingEntityDao.Properties.Key.eq(key),
                SettingEntityDao.Properties.UserId.eq(userId)).unique();
    }

    public void removeSetting(String lockKey, Long userId) {
        SettingEntity settingEntity = loadSetting(lockKey, userId);
        if (settingEntity != null) {
            mDao.delete(settingEntity);
        }
    }

    public void removeAllExpect(String deviceIdKey) {
        List<SettingEntity> list = mDao.queryBuilder()
                .where(SettingEntityDao.Properties.Key.notEq(deviceIdKey))
                .build()
                .list();
        mDao.deleteInTx(list);
    }
}
