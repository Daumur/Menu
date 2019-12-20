package com.example.menu;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API_REST {

    String URL = "https://raw.githubusercontent.com/Daumur/Menu/Developp/app/src/main/java/com/example/menu/";

    @GET("Destiny.json")
    Call<List<Arme>> GetArme();
}