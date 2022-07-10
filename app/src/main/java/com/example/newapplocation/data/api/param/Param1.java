package com.example.newapplocation.data.api.param;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;


@Parcel
public class Param1 {
    @SerializedName("property")
    String property;
    @SerializedName("value")
    String value;

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}