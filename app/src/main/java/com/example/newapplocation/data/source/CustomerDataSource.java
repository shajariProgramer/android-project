package com.example.newapplocation.data.source;

import com.example.newapplocation.data.db.AppDatabaseManager;
import com.example.newapplocation.data.entities.CustomerEntity;
import com.example.newapplocation.data.entities.CustomerEntityDao;

import java.util.List;


public class CustomerDataSource {
    private final CustomerEntityDao mDao;

    public CustomerDataSource(AppDatabaseManager databaseManager) {
        mDao = databaseManager.newSession().getCustomerEntityDao();
    }

    public List<CustomerEntity> loadAll() {
        return mDao.queryBuilder().orderAsc(CustomerEntityDao.Properties.Priority).build().list();
    }

    public void saveAll(List<CustomerEntity> customerEntities) {
        mDao.insertOrReplaceInTx(customerEntities);
    }

    public void deleteAll() {
        mDao.deleteAll();
    }

    public void saveSelectedCustomer(CustomerEntity customerEntity) {
        List<CustomerEntity> all = loadAll();
        for (CustomerEntity c : all) {
            c.setIsSelected(false);
        }
        mDao.updateInTx(all);
        customerEntity.setIsSelected(true);
        mDao.update(customerEntity);
    }

    public CustomerEntity getSelectedCustomer() {
        return mDao.queryBuilder().where(CustomerEntityDao.Properties.IsSelected.eq(true)).unique();
    }
}
