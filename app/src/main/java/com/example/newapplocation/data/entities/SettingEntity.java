package com.example.newapplocation.data.entities;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class SettingEntity {
    @Id
    private Long id;
    private String key;
    private String value;
    private long userId;

    @Generated(hash = 1022207708)
    public SettingEntity(Long id, String key, String value, long userId) {
        this.id = id;
        this.key = key;
        this.value = value;
        this.userId = userId;
    }

    @Generated(hash = 1082063668)
    public SettingEntity() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
