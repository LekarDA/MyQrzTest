package model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by dmitriy on 22.06.15.
 */
public class DiplomModel {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String diplomName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDiplomName() {
        return diplomName;
    }

    public void setDiplomName(String diplomName) {
        this.diplomName = diplomName;
    }
    public static class List extends ArrayList<DiplomModel>implements Collection<DiplomModel>{

    }
}
