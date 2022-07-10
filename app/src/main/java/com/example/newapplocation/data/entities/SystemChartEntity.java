package com.example.newapplocation.data.entities;

import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class SystemChartEntity {

    @Id
    private Long id;
    @SerializedName("title")
    private String title;
    @SerializedName("parentId")
    private Long parentId;
    @SerializedName("isActive")
    private boolean isActive;
    @SerializedName("code")
    private String code;
    @Generated(hash = 1426309256)
    public SystemChartEntity(Long id, String title, Long parentId, boolean isActive,
                             String code) {
        this.id = id;
        this.title = title;
        this.parentId = parentId;
        this.isActive = isActive;
        this.code = code;
    }
    @Generated(hash = 642639827)
    public SystemChartEntity() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Long getParentId() {
        return this.parentId;
    }
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
    public boolean getIsActive() {
        return this.isActive;
    }
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
    public String getCode() {
        return this.code;
    }
    public void setCode(String code) {
        this.code = code;
    }

}
