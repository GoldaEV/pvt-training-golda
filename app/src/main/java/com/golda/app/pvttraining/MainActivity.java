package com.golda.app.pvttraining;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.golda.app.pvttraining.cw2.Cw2LoginActivity;
import com.golda.app.pvttraining.dz1.Dz1Activity;
import com.golda.app.pvttraining.dz2.Dz2Activity;
import com.golda.app.pvttraining.dz3.Dz3Activity;
import com.golda.app.pvttraining.dz4.Dz4Activity;
import com.golda.app.pvttraining.dz5.Dz5Activity;
import com.golda.app.pvttraining.dz6.Dz6Activity;

public class MainActivity extends Activity implements View.OnClickListener {


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);


        initGui();
    }

    private void initGui() {
        findViewById(R.id.dz1).setOnClickListener(this);;
        findViewById(R.id.dz2).setOnClickListener(this);;
        findViewById(R.id.dz3).setOnClickListener(this);;
        findViewById(R.id.dz4).setOnClickListener(this);;
        findViewById(R.id.dz5).setOnClickListener(this);;
        findViewById(R.id.dz6).setOnClickListener(this);;
        findViewById(R.id.cw2).setOnClickListener(this);;

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.dz1:
                startActivity(new Intent(this, Dz1Activity.class));
                break;
            case R.id.dz2:
                startActivity(new Intent(this, Dz2Activity.class));
                break;
            case R.id.dz3:
                startActivity(new Intent(this, Dz3Activity.class));
                break;
            case R.id.cw2:
                startActivity(new Intent(this, Cw2LoginActivity.class));
                break;
            case R.id.dz4:
                startActivity(new Intent(this, Dz4Activity.class));
                overridePendingTransition(R.anim.anim_1, R.anim.anim_2);
                break;
            case R.id.dz5:
                startActivity(new Intent(this, Dz5Activity.class));
                break;
            case R.id.dz6:
                startActivity(new Intent(this, Dz6Activity.class));
                break;
        }
    }

}