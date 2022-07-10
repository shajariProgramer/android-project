package com.example.newapplocation.data.api.response;

import com.google.gson.annotations.SerializedName;

public class LoginResponce {
    @SerializedName("response")
    String response;
    @SerializedName("username")
    String userName;
    @SerializedName("token")
    String token;
    @SerializedName("mobile_no")
    String mobileNumber;
    @SerializedName("name")
    String name;
    @SerializedName("is_legal_person")
    Boolean isLegalPerson;
    @SerializedName("is_admin")
    Boolean isAdmin;
    @SerializedName("is_staff")
    Boolean isStaff;

    public void setResponse(String response) {
        this.response = response;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getLegalPerson() {
        return isLegalPerson;
    }

    public void setLegalPerson(Boolean legalPerson) {
        isLegalPerson = legalPerson;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public Boolean getStaff() {
        return isStaff;
    }

    public void setStaff(Boolean staff) {
        isStaff = staff;
    }

    public String getResponse() {
        return response;
    }

    public String getUserName() {
        return userName;
    }

    public String getToken() {
        return token;
    }
}
