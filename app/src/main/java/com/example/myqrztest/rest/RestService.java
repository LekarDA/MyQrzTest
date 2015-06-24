package com.example.myqrztest.rest;

import com.octo.android.robospice.retrofit.RetrofitGsonSpiceService;

import com.example.myqrztest.api.GitApi;

/**
 * Created by dmitriy on 19.06.15.
 */
public class RestService extends RetrofitGsonSpiceService {
    private static final String URL = "http://api.qrz.ru/mobile/v1";

    @Override
    public void onCreate() {
        super.onCreate();
        addRetrofitInterface(GitApi.class);
    }

    @Override
    protected String getServerUrl() {
        return URL;
    }


}
