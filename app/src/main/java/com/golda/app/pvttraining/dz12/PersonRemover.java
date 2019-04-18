package com.golda.app.pvttraining.dz12;

import com.golda.app.pvttraining.dz6.Person;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PersonRemover {

    private DataServerManager dataManager = DataServerManager.getInstance();

    public void removeItem(Person person) {
        Call<Person> personCall = NetworkService.getInstance().getJSONApi().removePerson(person.getObjectId());
        personCall.enqueue(new Callback<Person>() {
            @Override
            public void onResponse(Call<Person> call, Response<Person> response) {
                dataManager.getPersons();
            }

            @Override
            public void onFailure(Call<Person> call, Throwable t) {

            }
        });

    }
   
}
