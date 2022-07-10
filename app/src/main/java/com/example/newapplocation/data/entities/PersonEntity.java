package com.example.newapplocation.data.entities;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class PersonEntity {
    @Id
    private Long id;
    private String token;
    private String name;
    private String userName;
    private String mobile;
    private Boolean isLegalPerson;
    private Boolean isAdmin;
    private Boolean isStaff;

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

    @Generated(hash = 870706205)
    public PersonEntity(Long id, String token, String name, String userName,
                        String mobile, Boolean isLegalPerson, Boolean isAdmin,
                        Boolean isStaff) {
        this.id = id;
        this.token = token;
        this.name = name;
        this.userName = userName;
        this.mobile = mobile;
        this.isLegalPerson = isLegalPerson;
        this.isAdmin = isAdmin;
        this.isStaff = isStaff;
    }

    @Generated(hash = 69356185)
    public PersonEntity() {
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

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Boolean getIsLegalPerson() {
        return this.isLegalPerson;
    }

    public void setIsLegalPerson(Boolean isLegalPerson) {
        this.isLegalPerson = isLegalPerson;
    }

    public Boolean getIsAdmin() {
        return this.isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Boolean getIsStaff() {
        return this.isStaff;
    }

    public void setIsStaff(Boolean isStaff) {
        this.isStaff = isStaff;
    }
}
