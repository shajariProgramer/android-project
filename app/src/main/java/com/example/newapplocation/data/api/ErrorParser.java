package com.example.newapplocation.data.api;

import android.content.Context;

import com.example.newapplocation.R;
import com.example.newapplocation.domain.entities.exeption.ServerException;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.net.ConnectException;
import java.net.UnknownHostException;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.HttpException;
import retrofit2.Response;
import retrofit2.Retrofit;


public class ErrorParser {
    private final Context mContext;
    private final Retrofit mRetrofit;

    public ErrorParser(Context context, Retrofit retrofit) {
        mContext = context;
        mRetrofit = retrofit;
    }

    public APIError parseError(Response<?> response) {
        Converter<ResponseBody, APIError> converter =
                mRetrofit.responseBodyConverter(APIError.class, new Annotation[0]);

        APIError error;

        try {
            error = converter.convert(response.errorBody());
        } catch (IOException e) {
            e.printStackTrace();
            return new APIError(500, mContext.getString(R.string.error_parse_data));
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            return new APIError(500, mContext.getString(R.string.error_parse_data));
        }

        return error;
    }

    public APIError parseError(Throwable t) {
        if (t instanceof ServerException) {
            ServerException exception = (ServerException) t;
            return new APIError(500, exception.getError());
        }
        if (t instanceof NullPointerException) {
            return new APIError(500, t.getMessage());
        }
        if (t instanceof HttpException) {
            HttpException exception = (HttpException) t;
            if (exception.code() == 485) {
                return new APIError(485, mContext.getString(R.string.error_request_required_validation_code));
            }
            return parseError(exception.response());
        }
        if (t instanceof UnknownHostException) {
            return new APIError(0, mContext.getString(R.string.error_no_internet_connection));
        }
        if (t instanceof ConnectException) {
            return new APIError(0, mContext.getString(R.string.error_server_connection));
        }
        return new APIError(0, mContext.getString(R.string.error_parse_data));
    }
}
