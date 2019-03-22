package com.golda.app.pvttraining.dz6;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.golda.app.pvttraining.R;

public class PersonsListFragment extends Fragment {

    private static final String URL_STRING = "http://kiparo.ru/t/test.json";
    private DataManager dataManager;
    private RecyclerView recyclerView;
    private MyListAdapter myListAdapter;
    private Activity activity;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_person_list, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        dataManager = DataManager.getInstance();
        dataManager.setChangeListener(new DataManager.ChangeListener() {
            @Override
            public void onChanged() {
                myListAdapter.notifyDataSetChanged();
            }
        });
        recyclerView = view.findViewById(R.id.recycleListView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        myListAdapter = new MyListAdapter();
        myListAdapter.setList(dataManager.getPersonList());
        myListAdapter.setOnItemClickListener(onItemClickListener);
        myListAdapter.setOnItemLongClickListener(onItemLongClickListener);
        recyclerView.setAdapter(myListAdapter);

        view.findViewById(R.id.buttonAdd).setOnClickListener(onClickAdd);

    }

    @Override
    public void onStart() {
        super.onStart();

        if (dataManager.isListEmpty()) new DataLoader().loadData(getContext(), URL_STRING);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (Activity) context;
    }


    private MyListAdapter.OnItemClickListener onItemClickListener = new MyListAdapter.OnItemClickListener() {
        @Override
        public void onClick(Person item) {
            try {
                ((EditableConnector) activity).editPerson(item.getId());
            } catch (ClassCastException e) {
            }
        }
    };


    private MyListAdapter.OnItemLongClickListener onItemLongClickListener = new MyListAdapter.OnItemLongClickListener() {
        @Override
        public void onLongClick(final Person item) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
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

    private View.OnClickListener onClickAdd = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            try {
                ((EditableConnector) activity).editPerson(-1);
            } catch (ClassCastException e) {
            }
        }
    };

    public interface EditableConnector {

        void editPerson(int id);
    }
}
