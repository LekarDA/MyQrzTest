package model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by dmitriy on 22.06.15.
 */
public class RegionModel {
    private int id;
    @SerializedName("name")
    private String region;


    public String getName() {
        return region;
    }

    public void setName(String region) {
        this.region = region;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static class List extends ArrayList<RegionModel> implements Collection<RegionModel> {
    }
}
