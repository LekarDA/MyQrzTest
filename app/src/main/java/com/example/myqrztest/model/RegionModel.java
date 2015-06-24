package com.example.myqrztest.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by dmitriy on 22.06.15.
 */
public class RegionModel {
    private long id;
    @SerializedName("name")
    private String region;


    public String getName() {
        return region;
    }

    public void setName(String region) {
        this.region = region;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public static class List extends ArrayList<RegionModel>{
    }
}
