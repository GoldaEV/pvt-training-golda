package com.golda.app.pvttraining.dz6;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.golda.app.pvttraining.R;

public class Dz6Activity extends Activity {

    private static final String URL_STRING = "http://kiparo.ru/t/test.json";
    private DataManager dataManager;
    private RecyclerView recyclerView;
    private MyListAdapter myListAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dz6);
        dataManager = DataManager.getInstance();
        dataManager.setChangeListener(new DataManager.ChangeListener() {
            @Override
            public void onChanged() {
                myListAdapter.notifyDataSetChanged();
            }
        });
        recyclerView = findViewById(R.id.recycleListView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        myListAdapter = new MyListAdapter();
        myListAdapter.setList(dataManager.getPersonList());
        myListAdapter.setOnItemClickListener(new MyListAdapter.OnItemClickListener() {
            @Override
            public void onClick(Person item) {
                Intent intent = new Intent(Dz6Activity.this, EditItemActivity.class);
                intent.putExtra(EditItemActivity.EXTRA_EDIT_ITEM, item.getId());
                startActivity(intent);
            }
        });
        myListAdapter.setOnItemLongClickListener(new MyListAdapter.OnItemLongClickListener() {
            @Override
            public void onLongClick(final Person item) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Dz6Activity.this);
                builder.setTitle("Remove " + item.getName());
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.setPositiveButton("Remove", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dataManager.removeItem(item);
                    }
                });
                builder.show();
            }
        });

        recyclerView.setAdapter(myListAdapter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        if (dataManager.isListEmpty()) new DataLoader().loadData(this, URL_STRING);

    }


}
