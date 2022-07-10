package com.example.newapplocation.data.entities;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class FeatureEntity {
    @Id
    private Long id;
    private String token;
    private String userKayParams;
    private String otp;
    private String scKayParam;
    private String urlConnection;
    @Generated(hash = 2120660186)
    public FeatureEntity(Long id, String token, String userKayParams, String otp,
                         String scKayParam, String urlConnection) {
        this.id = id;
        this.token = token;
        this.userKayParams = userKayParams;
        this.otp = otp;
        this.scKayParam = scKayParam;
        this.urlConnection = urlConnection;
    }
    @Generated(hash = 247241888)
    public FeatureEntity() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getToken() {
        return this.token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public String getUserKayParams() {
        return this.userKayParams;
    }
    public void setUserKayParams(String userKayParams) {
        this.userKayParams = userKayParams;
    }
    public String getOtp() {
        return this.otp;
    }
    public void setOtp(String otp) {
        this.otp = otp;
    }
    public String getScKayParam() {
        return this.scKayParam;
    }
    public void setScKayParam(String scKayParam) {
        this.scKayParam = scKayParam;
    }
    public String getUrlConnection() {
        return this.urlConnection;
    }
    public void setUrlConnection(String urlConnection) {
        this.urlConnection = urlConnection;
    }
}
