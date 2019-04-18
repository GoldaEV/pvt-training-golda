package com.golda.app.pvttraining.dz12;

import com.golda.app.pvttraining.dz6.Person;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PersonCreator {

    public void createItem(Person person) {
        Call<Person> personCall = NetworkService.getInstance().getJSONApi().createPerson(person);
        personCall.enqueue(new Callback<Person>() {
            @Override
            public void onResponse(Call<Person> call, Response<Person> response) {

            }

            @Override
            public void onFailure(Call<Person> call, Throwable t) {

            }
        });

    }
   
}
