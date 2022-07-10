package com.example.newapplocation.data.api.param;

import com.google.gson.annotations.SerializedName;

public class LoginParams {
    @SerializedName("username")
    String userName;
    @SerializedName("name")
    String name;
    @SerializedName("mobile_no")
    String mobile;
    @SerializedName("password")
    String password;
    @SerializedName("is_legal_person")
    int legalPerson;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(int legalPerson) {
        this.legalPerson = legalPerson;
    }
}
