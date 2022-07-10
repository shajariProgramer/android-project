package com.example.newapplocation.data.source;

import com.example.newapplocation.data.db.AppDatabaseManager;
import com.example.newapplocation.data.entities.MenuEntity;
import com.example.newapplocation.data.entities.MenuEntityDao;
import com.example.newapplocation.data.entities.ModuleEntity;
import com.example.newapplocation.data.entities.ModuleEntityDao;
import com.example.newapplocation.domain.entities.Module;

import org.greenrobot.greendao.query.WhereCondition;

import java.util.ArrayList;
import java.util.List;


public class MenuDataSource {

    private final ModuleEntityDao mModuleDao;
    private final MenuEntityDao mMenuDao;

    public MenuDataSource(AppDatabaseManager appDatabaseManager) {
        this.mModuleDao = appDatabaseManager.newSession().getModuleEntityDao();
        this.mMenuDao = appDatabaseManager.newSession().getMenuEntityDao();
    }

    public List<MenuEntity> getMenu(long groupId) {
        return mMenuDao.queryBuilder()
                .where(MenuEntityDao.Properties.ParentId.eq(groupId))
                .build()
                .list();
    }

    public void saveAll(List<Module> moduleList) {
        mModuleDao.deleteAll();
        mMenuDao.deleteAll();
        for (Module module : moduleList) {
            ModuleEntity moduleEntity = new ModuleEntity(module.getId(), module.getName(),
                    module.getTitle());
//            if (module.getMenus() != null) {
//                for (Menu menu : module.getMenus()) {
//                    MenuEntity menuEntity = new MenuEntity(menu.getId(), menu.getName(), menu.getTitle(),
//                            menu.getIcon(), menu.getModuleId(), menu.getSystemChartId(), moduleEntity.getId(), 0);
//                    mMenuDao.insertOrReplaceInTx(menuEntity);
//                }
//            }
            mModuleDao.insertOrReplaceInTx(moduleEntity);
        }
    }

    public Boolean addCounter(Long id) {
        MenuEntity entity = mMenuDao.queryBuilder()
                .where(MenuEntityDao.Properties.Id.eq(id))
                .build()
                .unique();
        if (entity != null) {
            Integer counts = entity.getCounter() != null ? entity.getCounter() : 0;
            entity.setCounter(counts + 1);
            mMenuDao.update(entity);
            return true;
        }
        return false;
    }

    public List<MenuEntity> getUserTopItems(Long systemChartId, List<Long> ids) {
        WhereCondition condition;
        if (systemChartId != -1) {
            condition = mMenuDao.queryBuilder().and(MenuEntityDao.Properties.Id.in(ids),
                    mMenuDao.queryBuilder().or(
                            MenuEntityDao.Properties.SystemChartId.eq(systemChartId),
                            MenuEntityDao.Properties.SystemChartId.isNull()));
        } else {
            condition = mMenuDao.queryBuilder().and(MenuEntityDao.Properties.Id.in(ids),
                    MenuEntityDao.Properties.SystemChartId.isNull());
        }
        return mMenuDao.queryBuilder()
                .where(condition)
                .limit(5)
                .orderDesc(MenuEntityDao.Properties.Counter)
                .build()
                .list();
    }

    public List<Module> loadModules() {
        List<Module> result = new ArrayList<>();
        List<ModuleEntity> modules = mModuleDao.loadAll();
        for (ModuleEntity moduleEntity : modules) {
            Module module = new Module(moduleEntity.getId(),
                    moduleEntity.getName(), moduleEntity.getTitle(), "", null);
            result.add(module);
        }
        return result;
    }

    public void removeAll() {
        mModuleDao.deleteAll();
        mMenuDao.deleteAll();
    }
}
