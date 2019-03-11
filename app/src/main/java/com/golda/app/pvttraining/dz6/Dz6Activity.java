package com.golda.app.pvttraining.dz6;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.golda.app.pvttraining.R;

import java.util.List;

public class Dz6Activity extends Activity {

    private List<Person> persons;
    private static final String URL_STRING = "http://kiparo.ru/t/test.json";
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dz6);
        persons = DataList.getInstance().getPersonList();
        recyclerView = findViewById(R.id.recycleListView);

        MyListAdapter myListAdapter = new MyListAdapter();
        myListAdapter.setList(persons);
        recyclerView.setAdapter(myListAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        new DataLoader().loadData(this, URL_STRING);

    }


}
