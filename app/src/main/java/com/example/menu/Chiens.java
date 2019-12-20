package com.example.menu;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Chiens {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("race")
    @Expose
    private String race;
    @SerializedName("age")
    @Expose
    private String age;


    public String getImgURL(){

        return image;

    }

    public void setImgURL(String imgURL){

        this.image = imgURL;

    }

    public String getName(){

        return name;

    }
    public void setName(String name){

        this.name=name;

    }

    public String getrace() {

        return race;

    }
    public void setrace(String race) {

        this.race = race;
    }
    public String getage(){

        return age;

    }
    public void setage(String age){

        this.age = age;

    }

}
