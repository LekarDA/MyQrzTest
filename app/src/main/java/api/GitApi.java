package api;

import rest.GetCountries;


import rest.GetDiplomsByRegions;
import rest.GetRegions;
import retrofit.http.GET;
import retrofit.http.Path;
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
    public GetDiplomsByRegions.Response.Body getDiplomByRegions(@Query("cid")long cid,@Query("rid")long rid);}