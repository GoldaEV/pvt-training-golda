package com.golda.app.pvttraining;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.golda.app.pvttraining.dz1.Dz1Activity;

public class MainActivity extends Activity implements View.OnClickListener {

    Button dz1;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);

        initGui();

    }

    private void initGui() {
        dz1 = findViewById(R.id.dz1);
        dz1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.dz1:
                startActivity(new Intent(this, Dz1Activity.class));
                break;
        }
    }

}