package com.golda.app.pvttraining.dz4;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewSwitcher;
import com.golda.app.pvttraining.R;

import java.util.Random;

public class Dz4Activity extends Activity implements ViewSwitcher.ViewFactory {
    private static final int minDelay = 3000;
    private static final int maxDelay = 7000;
    private static final int animDelay = 300;

    private ImageSwitcher mImageSwitcher;
    private int animationCounter = 0;
    private Handler imageSwitcherHandler;
    private int[] mImageIds = { R.drawable.sv1, R.drawable.sv2, R.drawable.sv3};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.layout_dz4);

            mImageSwitcher = findViewById(R.id.imageSwitcher);
            mImageSwitcher.setFactory(this);

            Animation outAnimation = new AlphaAnimation(1, 0);
            outAnimation.setDuration(150);
            mImageSwitcher.setOutAnimation(outAnimation);
            mImageSwitcher.setImageResource(mImageIds[0]);

            imageSwitcherHandler = new Handler(Looper.getMainLooper());
            imageSwitcherHandler.post(new Runnable() {
                @Override
                public void run() {
                    switch (animationCounter++) {
                        case 0:
                            mImageSwitcher.setImageResource(mImageIds[1]);
                            break;
                        case 1:
                            mImageSwitcher.setImageResource(mImageIds[2]);
                            break;
                        case 2:
                            mImageSwitcher.setImageResource(mImageIds[1]);
                            break;
                        case 3:
                            mImageSwitcher.setImageResource(mImageIds[0]);
                            break;
                    }
                    if (animationCounter < 4) {
                        imageSwitcherHandler.postDelayed(this, animDelay);
                    } else {
                        animationCounter = 0;
                        imageSwitcherHandler.postDelayed(this, getRandomNumberInRange(minDelay, maxDelay));
                    }
                }
            });

        }

    private static int getRandomNumberInRange(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }

        @Override
        public View makeView() {
            ImageView imageView = new ImageView(this);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setLayoutParams(new
                    ImageSwitcher.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
            return imageView;
        }
}
