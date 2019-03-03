package com.golda.app.pvttraining.dz4;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;

import com.golda.app.pvttraining.R;

public class Dz4Activity extends Activity {
    private ImageSwitcher imageSwitcher;
    private int animationCounter = 1;
    private Handler imageSwitcherHandler;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dz4);

        imageSwitcher = findViewById(R.id.slide_trans_imageswitcher);

//        Animation in  = AnimationUtils.loadAnimation(this, R.anim.left_to_right_in);
//        Animation out = AnimationUtils.loadAnimation(this, R.anim.left_to_right_out);
//
//        imageSwitcher.setInAnimation(in);
//        imageSwitcher.setOutAnimation(out);

        imageSwitcherHandler = new Handler(Looper.getMainLooper());
        imageSwitcherHandler.post(new Runnable() {
            @Override
            public void run() {
                switch (animationCounter++) {
                    case 1:
                        imageSwitcher.setImageResource(R.drawable.sova_anmation_1);
                        break;
                    case 2:
                        imageSwitcher.setImageResource(R.drawable.sova_anmation_2);
                        break;
                    case 3:
                        imageSwitcher.setImageResource(R.drawable.sova_anmation_3);
                        break;
                }
                animationCounter %= 4;
                if(animationCounter == 0 ) animationCounter = 1;

                imageSwitcherHandler.postDelayed(this, 3000);
            }
        });

    }


}
