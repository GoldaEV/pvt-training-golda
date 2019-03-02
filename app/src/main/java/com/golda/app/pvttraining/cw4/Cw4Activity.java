package com.golda.app.pvttraining.cw4;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.golda.app.pvttraining.R;

public class Cw4Activity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_cw4);


        Manager.getInstance().setCw4Activity(this);
    }
}
