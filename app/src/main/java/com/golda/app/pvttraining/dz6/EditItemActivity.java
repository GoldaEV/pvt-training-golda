package com.golda.app.pvttraining.dz6;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.golda.app.pvttraining.R;

public class EditItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_edit_person);

        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragmentEditPerson);
        if (fragment != null) {
            fragment.asdadasda(1);
        }

    }

    @Override
    protected void onResume() {
        super.onResume();


    }



}

