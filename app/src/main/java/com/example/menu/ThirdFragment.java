package com.example.menu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class ThirdFragment extends Fragment {
    private ListView listView;
    private RetroAdapter retroAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_third,container,false);
        listView = view.findViewById(R.id.lv);
        getJSONResponse();
        return view;

    }

    private void getJSONResponse(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyInterface.JSONURL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        MyInterface api = retrofit.create(MyInterface.class);

        Call<String> call = api.getString();

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.i("Responsestring", response.body().toString());
                //Toast.makeText()
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Log.i("onSuccess", response.body().toString());

                        String jsonresponse = response.body().toString();
                        writeListView(jsonresponse);

                    } else {
                        Log.i("onEmptyResponse", "Returned empty response");//Toast.makeText(getContext(),"Nothing returned",Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }

    private void writeListView(String response){

        try {
            //getting the whole json object from the response
            JSONObject obj = new JSONObject(response);
            if(obj.optString("status").equals("true")){

                ArrayList<ModelListView> modelListViewArrayList = new ArrayList<>();
                JSONArray dataArray  = obj.getJSONArray("data");

                for (int i = 0; i < dataArray.length(); i++) {

                    ModelListView modelListView = new ModelListView();
                    JSONObject dataobj = dataArray.getJSONObject(i);

                    modelListView.setImgURL(dataobj.getString("imgURL"));
                    modelListView.setName(dataobj.getString("name"));
                    modelListView.setCountry(dataobj.getString("country"));
                    modelListView.setCity(dataobj.getString("city"));

                    modelListViewArrayList.add(modelListView);

                }

                retroAdapter = new RetroAdapter(getContext(), modelListViewArrayList);
                listView.setAdapter(retroAdapter);

            }else {
                Toast.makeText(getContext(), obj.optString("message")+"", Toast.LENGTH_SHORT).show();
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}