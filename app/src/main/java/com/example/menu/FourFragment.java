package com.example.menu;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;


public class FourFragment extends Fragment {

    private RecyclerView armeRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    List<Arme> armeList = new ArrayList<>();
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            View view = inflater.inflate(R.layout.fragment_four, container, false);

            armeRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

            appelAPI();

            return view;
        }

        void appelAPI(){
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(API_REST.URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
            final API_REST response = retrofit.create(API_REST.class);
            Call<List<Arme>> call = (response).GetArme();
            call.enqueue(new Callback<List<Arme>>() {
                @Override
                public void onResponse(Call<List<Arme>> call, Response<List<Arme>> response) {
                    armeList =response.body();
                    creationList(armeList);
                }

                @Override
                public void onFailure(Call<List<Arme>> call, Throwable t) {
                    Log.d("ERROR", "API ERROR");
                }
            });
        }

        void creationList(List<Arme> armeList) {


            Arme arme = new Arme();
            arme.setName("Le fardeau d'Izanagi");
            arme.setDifficulté("Quête");
            arme.setType("Energétique");

            layoutManager = new LinearLayoutManager(getContext());
            armeRecyclerView.setLayoutManager(layoutManager);
            mAdapter = new MyAdapter(armeList);
            armeRecyclerView.setAdapter(mAdapter);


        }
}
