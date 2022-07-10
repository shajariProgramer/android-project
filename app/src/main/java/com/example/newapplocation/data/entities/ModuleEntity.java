package com.example.newapplocation.data.entities;

import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class ModuleEntity {
    @Id
    private Long id;
    @SerializedName("name")
    private String name;
    @SerializedName("title")
    private String title;
    @Generated(hash = 83570857)
    public ModuleEntity(Long id, String name, String title) {
        this.id = id;
        this.name = name;
        this.title = title;
    }
    @Generated(hash = 1314096604)
    public ModuleEntity() {
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
}
