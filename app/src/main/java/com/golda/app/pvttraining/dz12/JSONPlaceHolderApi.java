package com.golda.app.pvttraining.dz12;

import com.golda.app.pvttraining.dz6.Person;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface JSONPlaceHolderApi {
    String DB_URL = "FD7FE946-1DEE-555C-FF23-B73859B3D800/E862840C-2D42-A2F2-FF12-8F4FC6146800/data/Person";

    @GET(DB_URL)
    Call<ArrayList<Person>> getPersons();

    @GET(DB_URL + "/{objectId}")
    Call<Person> getPersonByID(@Path("objectId") String objectId);

    @POST(DB_URL)
    Call<Person> createPerson(@Body Person person);

    @DELETE(DB_URL + "/{objectId}")
    Call<Person> removePerson(@Path("objectId") String objectId);

    @PUT(DB_URL + "/{objectId}")
    Call<Void> editStudent(@Path("objectId") String objectId, @Body Person student);
}
