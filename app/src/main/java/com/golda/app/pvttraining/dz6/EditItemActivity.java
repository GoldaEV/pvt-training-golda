package com.golda.app.pvttraining.dz6;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.golda.app.pvttraining.R;

public class EditItemActivity extends AppCompatActivity implements EditPersonFragment.FragmentCloser {
    public static final String EXTRA_EDIT_ITEM = "EXTRA_EDIT_ITEM";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_edit_person);
        Intent intent = getIntent();
        String editID = intent.getStringExtra(EXTRA_EDIT_ITEM);

        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragmentEditPerson);
        if (fragment != null) {
            ((EditPersonFragment) fragment).displayDetails(editID);
        }

    }


    @Override
    public void close() {
            finish();
    }
}

