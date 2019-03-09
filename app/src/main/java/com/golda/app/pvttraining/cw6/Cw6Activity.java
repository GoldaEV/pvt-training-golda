package com.golda.app.pvttraining.cw6;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.golda.app.pvttraining.R;

import java.util.ArrayList;

public class Cw6Activity extends Activity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_cw6);

        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
//        recyclerView.addItemDecoration(new );  ---------   создание отступов между элементами
        ArrayList<Student>  list = new ArrayList<>();
        list.add(new Student("Ivan", "https://picsum.photos/150/150/?random"));
        list.add(new Student("Ivan1", "https://picsum.photos/150/150/?random"));
        list.add(new Student("Ivan2", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQv8Z8uwifRFdln2e-l9OWmyjEHQm5ZIOMfsPMYoZK-1QPLpQ2iPw"));
        list.add(new Student("", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS9VO9Fc41pWEe2iuP-x2blhMLrEddgNczzANsHlP-AjtfoefJM"));
        list.add(new Student("Ivan4", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRj0lkYUHDfnphv6gn60wrF44cE9U1JoxOAwJIEIclk6RYJnz1V"));
        list.add(new Student("Ivan6", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRj0lkYUHDfnphv6gn60wrF44cE9U1JoxOAwJIEIclk6RYJnz1V"));
        list.add(new Student("Ivan8", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSo1wyohXRrEdwbwk48UFEAuFj-AYqz454RVb2YY1JpTUI8NTABMA"));
        list.add(new Student("Ivan6", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQr8HRSC3I5oFIrxw9T7bW3tv1D5r2NnBAVFvxV-eQ_kBwuNszb"));
        list.add(new Student("Ivan5", ""));
        list.add(new Student("Ivan4", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQc38ZoDb_1yIvu4cdAt4UKh-mGDFAL-tifQq0OIKfPxG6Rpjff"));

        MyListAdapter myListAdapter = new MyListAdapter();
        myListAdapter.setList(list);

        recyclerView.setAdapter(myListAdapter);
    }
}