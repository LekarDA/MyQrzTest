package com.example.myqrztest.api;

import com.example.myqrztest.model.DiplomDetailModel;
import com.example.myqrztest.rest.GetCountries;


import com.example.myqrztest.rest.GetDetailDiplom;
import com.example.myqrztest.rest.GetDiplomsByRegions;
import com.example.myqrztest.rest.GetRegions;

import retrofit.http.GET;
import retrofit.http.Query;


/**
 * Created by dmitriy on 17.06.15.
 */
public interface GitApi {
    @GET("/reference/countries")
    public GetCountries.Response.Body getCountries();

    @GET("/reference/regions")
    public GetRegions.Response.Body getRegions();

    @GET("/awards/country")
    public GetDiplomsByRegions.Response.Body getDiplomByRegions(@Query("cid") long cid, @Query("rid") long rid);

    @GET("/awards/view")
    public DiplomDetailModel getDiplomDetail(@Query("id") long id);
}