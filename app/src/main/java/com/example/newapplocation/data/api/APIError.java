package com.example.newapplocation.data.api;

import com.google.gson.annotations.SerializedName;

public class APIError {
    private int statusCode;
    @SerializedName("error")
    private String error;

    APIError(int statusCode, String message) {
        this.statusCode = statusCode;
        this.error = message;
    }

    public int status() {
        return statusCode;
    }

    public String message() {
        return error;
    }
}
