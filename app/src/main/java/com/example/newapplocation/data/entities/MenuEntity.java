package com.example.newapplocation.data.entities;


import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class MenuEntity {

    @Id
    private Long id;
    @SerializedName("name")
    private String name;
    @SerializedName("title")
    private String title;
    @SerializedName("icon")
    private String icon;
    @SerializedName("moduleId")
    private Long moduleId;
    @SerializedName("systemChartId")
    private Long systemChartId;
    private Long parentId;
    private Integer counter;

    @Generated(hash = 793842766)
    public MenuEntity(Long id, String name, String title, String icon,
                      Long moduleId, Long systemChartId, Long parentId, Integer counter) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.icon = icon;
        this.moduleId = moduleId;
        this.systemChartId = systemChartId;
        this.parentId = parentId;
        this.counter = counter;
    }

    @Generated(hash = 1441921350)
    public MenuEntity() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Long getModuleId() {
        return this.moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    public Long getSystemChartId() {
        return this.systemChartId;
    }

    public void setSystemChartId(Long systemChartId) {
        this.systemChartId = systemChartId;
    }

    public Long getParentId() {
        return this.parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getCounter() {
        return this.counter;
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
    }

}
