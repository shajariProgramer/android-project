package com.example.newapplocation.domain.entities.exeption;

public class ServerException extends Exception {

    private final String mError;

    public ServerException(String error) {
        mError = error;
    }

    public String getError() {
        return mError;
    }
}
