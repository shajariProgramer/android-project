package com.example.newapplocation.data.entities;

import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;

@Entity
public class PostEntity {

    @Id
    private Long id;
    @SerializedName("fromDate")
    private String fromDate;
    @SerializedName("toDate")
    private String toDate;
    @SerializedName("isBase")
    private boolean isBase;
    private boolean isCurrent;
    @SerializedName("systemChartId")
    private Long systemChartId;
    @SerializedName("systemChart")
    @ToOne(joinProperty = "systemChartId")
    private SystemChartEntity systemChart;
    /**
     * Used to resolve relations
     */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /**
     * Used for active entity operations.
     */
    @Generated(hash = 1666881267)
    private transient PostEntityDao myDao;
    @Generated(hash = 312004410)
    private transient Long systemChart__resolvedKey;

    @Generated(hash = 1448506029)
    public PostEntity(Long id, String fromDate, String toDate, boolean isBase,
                      boolean isCurrent, Long systemChartId) {
        this.id = id;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.isBase = isBase;
        this.isCurrent = isCurrent;
        this.systemChartId = systemChartId;
    }

    @Generated(hash = 1061262511)
    public PostEntity() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFromDate() {
        return this.fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return this.toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public boolean getIsBase() {
        return this.isBase;
    }

    public void setIsBase(boolean isBase) {
        this.isBase = isBase;
    }

    public boolean getIsCurrent() {
        return this.isCurrent;
    }

    public void setIsCurrent(boolean isCurrent) {
        this.isCurrent = isCurrent;
    }

    public Long getSystemChartId() {
        return this.systemChartId;
    }

    public void setSystemChartId(Long systemChartId) {
        this.systemChartId = systemChartId;
    }

    /**
     * To-one relationship, resolved on first access.
     */
    @Generated(hash = 2025494046)
    public SystemChartEntity getSystemChart() {
        Long __key = this.systemChartId;
        if (systemChart__resolvedKey == null
                || !systemChart__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            SystemChartEntityDao targetDao = daoSession.getSystemChartEntityDao();
            SystemChartEntity systemChartNew = targetDao.load(__key);
            synchronized (this) {
                systemChart = systemChartNew;
                systemChart__resolvedKey = __key;
            }
        }
        return systemChart;
    }

    /**
     * called by internal mechanisms, do not call yourself.
     */
    @Generated(hash = 1975930477)
    public void setSystemChart(SystemChartEntity systemChart) {
        synchronized (this) {
            this.systemChart = systemChart;
            systemChartId = systemChart == null ? null : systemChart.getId();
            systemChart__resolvedKey = systemChartId;
        }
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 643091034)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getPostEntityDao() : null;
    }
}
