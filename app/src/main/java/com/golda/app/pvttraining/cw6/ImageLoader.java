package com.golda.app.pvttraining.cw6;

import android.widget.ImageView;

import com.squareup.picasso.Picasso;

class ImageLoader {
    public static void loadImage(ImageView imageView, String urlImage) {
        Picasso.get().load(urlImage).into(imageView);
    }

    public static void cancel(ImageView imageView) {
        Picasso.get().cancelRequest(imageView);
    }
}
