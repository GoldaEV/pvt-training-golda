package com.golda.app.pvttraining.dz6;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.golda.app.pvttraining.R;


public class MyListViewHolder extends RecyclerView.ViewHolder {
    private TextView name;
    private TextView surname;

    public MyListViewHolder(View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.name);
        surname = itemView.findViewById(R.id.surname);
    }


    public void bind(Person item) {
        if (item.getName() != null) {
            name.setText(item.getName());
        } else {
            name.setText("");
        }

        if (item.getSurname() != null) {
            surname.setText(item.getName());
        } else {
            surname.setText("");
        }

    }
}
