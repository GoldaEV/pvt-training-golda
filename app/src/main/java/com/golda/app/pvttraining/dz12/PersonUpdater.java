package com.golda.app.pvttraining.dz12;

import com.golda.app.pvttraining.dz6.Person;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PersonUpdater {

    private DataServerManager dataManager = DataServerManager.getInstance();

    public void updateItem(Person person) {

        Call<Void> voidCall = NetworkService.getInstance().getJSONApi().editStudent(person.getObjectId(), person);
        voidCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                dataManager.getPersons();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });


    }

}
