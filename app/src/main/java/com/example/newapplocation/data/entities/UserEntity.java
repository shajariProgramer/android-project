package com.example.newapplocation.data.entities;

import com.example.newapplocation.core.Exclude;
import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;


@Entity
public class UserEntity {

    @Id
    @Exclude
    private Long id;
    @SerializedName("id")
    private String key;
    private String accessedAt;
    private String name;
    private String userName;
    private String token;
    @SerializedName("pid")
    private long portalId;
    @Generated(hash = 845005939)
    public UserEntity(Long id, String key, String accessedAt, String name,
                      String userName, String token, long portalId) {
        this.id = id;
        this.key = key;
        this.accessedAt = accessedAt;
        this.name = name;
        this.userName = userName;
        this.token = token;
        this.portalId = portalId;
    }
    @Generated(hash = 1433178141)
    public UserEntity() {
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
    public String getAccessedAt() {
        return this.accessedAt;
    }
    public void setAccessedAt(String accessedAt) {
        this.accessedAt = accessedAt;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUserName() {
        return this.userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getToken() {
        return this.token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public long getPortalId() {
        return this.portalId;
    }
    public void setPortalId(long portalId) {
        this.portalId = portalId;
    }

}
