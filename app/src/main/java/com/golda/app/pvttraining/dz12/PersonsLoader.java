package com.golda.app.pvttraining.dz12;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import com.golda.app.pvttraining.dz6.DataManager;
import com.golda.app.pvttraining.dz6.Person;
import com.golda.app.pvttraining.dz6.Students;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PersonsLoader {

    private DataServerManager dataManager = DataServerManager.getInstance();

    public void loadData() {
        Call<ArrayList<Person>> persons = NetworkService.getInstance().getJSONApi().getPersons();
        persons.enqueue(new Callback<ArrayList<Person>>() {
            @Override
            public void onResponse(Call<ArrayList<Person>> call, Response<ArrayList<Person>> response) {
                ArrayList<Person> body = response.body();
                dataManager.setPersons(body);
            }

            @Override
            public void onFailure(Call<ArrayList<Person>> call, Throwable t) {

            }
        });
    }

}
