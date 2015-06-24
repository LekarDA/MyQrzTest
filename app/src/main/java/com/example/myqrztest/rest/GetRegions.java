package com.example.myqrztest.rest;

import com.google.gson.annotations.SerializedName;
import com.octo.android.robospice.request.retrofit.RetrofitSpiceRequest;

import com.example.myqrztest.api.GitApi;
import com.example.myqrztest.model.RegionModel;

/**
 * Created by dmitriy on 22.06.15.
 */
public class GetRegions {
    public static class Request extends RetrofitSpiceRequest<RegionModel.List, GitApi>{

        public Request(){
            super(RegionModel.List.class,GitApi.class);

        }

        @Override
        public RegionModel.List loadDataFromNetwork() throws Exception {
            Response.Body response = getService().getRegions();
            return response.data;
        }
    }
    public class Response{
        public class Body{
            @SerializedName("status")
            private String status;

            @SerializedName("data")
            private RegionModel.List data;
        }
    }
}
