package com.golda.app.pvttraining;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.golda.app.pvttraining.cw2.Cw2LoginActivity;
import com.golda.app.pvttraining.cw5.Cw5Activity;
import com.golda.app.pvttraining.dz1.Dz1Activity;
import com.golda.app.pvttraining.dz2.Dz2Activity;
import com.golda.app.pvttraining.dz3.Dz3Activity;

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
        findViewById(R.id.cw2).setOnClickListener(this);;
        findViewById(R.id.cw5).setOnClickListener(this);;

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
            case R.id.cw5:
                startActivity(new Intent(this, Cw5Activity.class));
                break;
        }
    }

}