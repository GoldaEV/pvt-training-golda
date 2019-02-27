package com.golda.app.pvttraining.dz3;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.golda.app.pvttraining.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class Dz3Activity extends Activity {
    private Button btnDownload;
    private ImageView imageViewPic;
    private EditText editTextURL;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dz3);

        btnDownload = findViewById(R.id.btnLoad);
        imageViewPic = findViewById(R.id.ivPicture);
        editTextURL = findViewById(R.id.edUrl);
        progressBar = findViewById(R.id.progressBar);

        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadImage(String.valueOf(editTextURL.getText()), imageViewPic);
            }
        });
    }

    private void loadImage(String valueOf, ImageView imageViewPic) {
        progressBar.setVisibility(View.VISIBLE);
        Picasso.get().load(valueOf).into(imageViewPic, new Callback() {
            @Override
            public void onSuccess() {
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onError(Exception e) {
                Toast.makeText(Dz3Activity.this, "Error loading", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
