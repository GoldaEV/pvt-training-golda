package com.golda.app.pvttraining.dz6;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.golda.app.pvttraining.R;

public class Dz6Activity extends AppCompatActivity  implements PersonsListFragment.EditableConnector  {

    private boolean isDualFragment = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main_dz6);

        View fragment = findViewById(R.id.fragmentEditPerson);
        if (fragment != null) isDualFragment = true;
    }



    @Override
    public void editPerson(String id) {
        if (isDualFragment) {
            Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragmentEditPerson);
            if (fragment != null) {
                ((EditPersonFragment) fragment).displayDetails(id);
            }

        } else {
            Intent intent = new Intent(this, EditItemActivity.class);
            intent.putExtra(EditItemActivity.EXTRA_EDIT_ITEM, id);
            startActivity(intent);
        }
    }
}