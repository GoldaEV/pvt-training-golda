package com.golda.app.pvttraining;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.golda.app.pvttraining.cw2.Cw2LoginActivity;
import com.golda.app.pvttraining.dz1.Dz1Activity;
import com.golda.app.pvttraining.dz2.Dz2Activity;
import com.golda.app.pvttraining.dz5.Dz5Activity;

public class MainActivity extends Activity implements View.OnClickListener {

    private Button dz1;
    private Button dz2;
    private Button cw2;
    private Button dz5;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);

        initGui();
    }

    private void initGui() {
        dz1 = findViewById(R.id.dz1);
        dz2 = findViewById(R.id.dz2);
        cw2 = findViewById(R.id.cw2);
        dz5 = findViewById(R.id.dz5);

        dz1.setOnClickListener(this);
        dz2.setOnClickListener(this);
        cw2.setOnClickListener(this);
        dz5.setOnClickListener(this);
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
            case R.id.cw2:
                startActivity(new Intent(this, Cw2LoginActivity.class));
                break;
            case R.id.dz5:
                startActivity(new Intent(this, Dz5Activity.class));
                break;

        }
    }

}