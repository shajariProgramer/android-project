package com.example.newapplocation.data.entities;


import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class FinanceCycleEntity {

    @SerializedName("id")
    private long id;
    @SerializedName("financeType")
    private int financeCycleType;
    @SerializedName("code")
    private int code;
    @SerializedName("title")
    private String title;
    @SerializedName("startDate")
    private String startDate;
    @SerializedName("endDate")
    private String endDate;
    @SerializedName("isCurrent")
    private int isCurrent;

    @Generated(hash = 232378971)
    public FinanceCycleEntity(long id, int financeCycleType, int code, String title,
                              String startDate, String endDate, int isCurrent) {
        this.id = id;
        this.financeCycleType = financeCycleType;
        this.code = code;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isCurrent = isCurrent;
    }

    @Generated(hash = 1027087684)
    public FinanceCycleEntity() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getFinanceCycleType() {
        return this.financeCycleType;
    }

    public void setFinanceCycleType(int financeCycleType) {
        this.financeCycleType = financeCycleType;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return this.endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getIsCurrent() {
        return this.isCurrent;
    }

    public void setIsCurrent(int isCurrent) {
        this.isCurrent = isCurrent;
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && id == ((FinanceCycleEntity) obj).id;
    }
}
