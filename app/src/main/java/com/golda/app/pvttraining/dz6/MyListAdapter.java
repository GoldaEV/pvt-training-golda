package com.golda.app.pvttraining.dz6;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.golda.app.pvttraining.R;

import java.util.ArrayList;
import java.util.List;

class MyListAdapter extends RecyclerView.Adapter<MyListViewHolder> {
    private List<Person> list = new ArrayList<>();

    @NonNull
    @Override
    public MyListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_my_list, parent, false);

        final MyListViewHolder holder = new MyListViewHolder(view);
//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int position = holder.getAdapterPosition();
////                if (onItemClickListener != null) {
////                    onItemClickListener.onClick(list.get(position), position);
////                }
//            }
//        });

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyListViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(List<Person> list) {
        this.list = list;
        notifyDataSetChanged();
    }
}
