package com.golda.app.pvttraining.cw6;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.golda.app.pvttraining.R;

public class MyListViewHolder extends RecyclerView.ViewHolder {
    private ImageView imageView;
    private TextView textView;

    public MyListViewHolder(View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageView);
        textView = itemView.findViewById(R.id.textView);
    }

    public void bind(Student item, int position) {

        ImageLoader.cancel(imageView);

        if (!TextUtils.isEmpty(item.getUrlImage())) {
            ImageLoader.loadImage(imageView, item.getUrlImage());
        }else {
            imageView.setImageDrawable(null);
        }


        if (item.getName() != null) {
            textView.setText(item.getName());
        } else {
            textView.setText("");
        }


    }
}
