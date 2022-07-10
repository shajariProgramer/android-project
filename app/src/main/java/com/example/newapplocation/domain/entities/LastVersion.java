package com.example.newapplocation.domain.entities;

import com.google.gson.annotations.SerializedName;

public class LastVersion {
    @SerializedName("version")
    private int version;
    @SerializedName("appDownloadUrl")
    private String downloadServerUrl;
    @SerializedName("forceUpdate")
    private boolean forceUpDate;

    public String getDownloadServerUrl() {
        return downloadServerUrl;
    }

    public void setDownloadServerUrl(String downloadServerUrl) {
        this.downloadServerUrl = downloadServerUrl;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public boolean isForceUpDate() {
        return forceUpDate;
    }

    public void setForceUpDate(boolean forceUpDate) {
        this.forceUpDate = forceUpDate;
    }
}
