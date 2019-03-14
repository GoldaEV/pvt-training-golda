package com.golda.app.pvttraining.dz6;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

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
        myListAdapter.setOnItemClickListener(onItemClickListener);
        myListAdapter.setOnItemLongClickListener(onItemLongClickListener);
        recyclerView.setAdapter(myListAdapter);

        findViewById(R.id.buttonAdd).setOnClickListener(clickAddItem);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (dataManager.isListEmpty()) new DataLoader().loadData(this, URL_STRING);

    }



    private MyListAdapter.OnItemClickListener onItemClickListener = new MyListAdapter.OnItemClickListener() {
        @Override
        public void onClick(Person item) {
            Intent intent = new Intent(Dz6Activity.this, EditItemActivity.class);
            intent.putExtra(EditItemActivity.EXTRA_EDIT_ITEM, item.getId());
            startActivity(intent);
        }
    };

    private MyListAdapter.OnItemLongClickListener onItemLongClickListener = new MyListAdapter.OnItemLongClickListener() {
        @Override
        public void onLongClick(final Person item) {
            AlertDialog.Builder builder = new AlertDialog.Builder(Dz6Activity.this);
            builder.setTitle(getString(R.string.remove) + " " + item.getName());
            builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            builder.setPositiveButton(getString(R.string.remove), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dataManager.removeItem(item);
                }
            });
            builder.show();
        }
    };

    private View.OnClickListener clickAddItem = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(Dz6Activity.this, EditItemActivity.class);
            intent.putExtra(EditItemActivity.EXTRA_EDIT_ITEM, -1);
            startActivity(intent);
        }
    };

}
