package com.example.newapplocation.data.api.param;


import com.google.gson.annotations.SerializedName;

public class LastVersionParams {
    @SerializedName("uuid")
    private String uUId;
    @SerializedName("type")
    private String type;

    public LastVersionParams(String uUId, String type) {
        this.uUId = uUId;
        this.type = type;
    }

}
