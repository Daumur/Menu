package com.example.menu;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Arme {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("imgURL")
    @Expose
    private String imgURL;
    @SerializedName("difficulté")
    @Expose
    private String difficulté;
    @SerializedName("type")
    @Expose
    private String type;


    public String getImgURL(){

        return imgURL;

    }

    public void setImgURL(String imgURL){

        this.imgURL = imgURL;

    }

    public String getName(){

        return name;

    }
    public void setName(String name){

        this.name=name;

    }

    public String getType() {

        return type;

    }
    public void setType(String type) {

        this.type = type;
    }
    public String getDifficulté(){

        return difficulté;

    }
    public void setDifficulté(String difficulté){

        this.difficulté = difficulté;

    }

}
