package com.myapplicationdev.android.ndpsongscompilation;

import java.io.Serializable;

public class Songs implements Serializable {

    private int id;
    private String title;
    private String singer;
    private int year;
    private int stars;

    public Songs(String title, String singer, int year, int stars) {
        this.title = title;
        this.singer = singer;
        this.year = year;
        this.stars = stars;
    }

    public Songs(int id, String title, String singer, int year, int stars) {
        this.id = id;
        this.title = title;
        this.singer = singer;
        this.year = year;
        this.stars = stars;
    }

    public int getId() {
        return id;
    }

    public Songs setId(int id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Songs setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getSinger() {
        return singer;
    }

    public Songs setSinger(String singers) {
        this.singer = singer;
        return this;
    }

    public int getYear() {
        return year;
    }

    public Songs setYear(int year) {
        this.year = year;
        return this;
    }

    public int getStars() {
        return stars;
    }

    public Songs setStars(int stars) {
        this.stars = stars;
        return this;
    }

    @Override
    public String toString() {
        String starsString = "";
        if (stars == 5){
            starsString = "*****";
        } else if (stars == 4){
            starsString = "****";
        }

        for(int i = 0; i < stars; i++){
            starsString += "*";
        }
        return title + "\n" + singer + " - " + year + "\n" + starsString;
    }
}
