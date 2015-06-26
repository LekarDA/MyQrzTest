package com.example.myqrztest.model;

/**
 * Created by dmitriy on 26.06.15.
 */
public class DiplomDetailModel {

    private int award_type;

    private String name;

    private String sponsored;

    private String description;

    private float rating;

    private int votes;

    private String date_added;

    private String date_lastedit;

    private String image;

    private String url;

    private String email;

    private int hits;


    public int getAward_type() {
        return award_type;
    }

    public void setAward_type(int award_type) {
        this.award_type = award_type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSponsored() {
        return sponsored;
    }

    public void setSponsored(String sponsored) {
        this.sponsored = sponsored;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public String getDate_added() {
        return date_added;
    }

    public void setDate_added(String date_added) {
        this.date_added = date_added;
    }

    public String getDate_lastedit() {
        return date_lastedit;
    }

    public void setDate_lastedit(String date_lastedit) {
        this.date_lastedit = date_lastedit;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }
}