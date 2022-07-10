package com.example.newapplocation.data.api.param;

import com.google.gson.annotations.SerializedName;

public class ViewedParams {
    @SerializedName("referralId")
    private Long referralId;
    @SerializedName("origin")
    private String origin;

    public ViewedParams(Long referalId, String origin) {
        this.referralId = referalId;
        this.origin = origin;
    }
}
