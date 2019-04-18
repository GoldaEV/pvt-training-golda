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

    @GET("FD7FE946-1DEE-555C-FF23-B73859B3D800/E862840C-2D42-A2F2-FF12-8F4FC6146800/data/Person")
    public Call<ArrayList<Person>> getPersons();

    @POST("FD7FE946-1DEE-555C-FF23-B73859B3D800/E862840C-2D42-A2F2-FF12-8F4FC6146800/data/Person")
    public Call<Person> createPerson(@Body Person person);

    @DELETE("FD7FE946-1DEE-555C-FF23-B73859B3D800/E862840C-2D42-A2F2-FF12-8F4FC6146800/data/Person/{objectId}")
    public Call<Person> removePerson(@Path("objectId") String objectId);

    @PUT("BD6A1856-C855-3C8F-FF6D-CB79DCD38700/32C6E496-FCD4-35DF-FF39-49B49639E500/data/StudentsTable/{objectId}")
    public Call<Void> editStudent(@Path("objectId") String objectId, @Body Person student);
}
