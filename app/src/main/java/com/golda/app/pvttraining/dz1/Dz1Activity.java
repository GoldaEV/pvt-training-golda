package com.golda.app.pvttraining.dz1;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.golda.app.pvttraining.R;

public class Dz1Activity extends Activity implements View.OnClickListener {

    TextView tvLeft, tvRight;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dz1);

        initGui();

    }

    private void initGui() {
        tvLeft = findViewById(R.id.tvLeft);
        tvRight = findViewById(R.id.tvRight);
        button = findViewById(R.id.button);

        button.setOnClickListener(this);
        button.setOnClickListener(myClickListener);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeText();
            }
        });
    }

    public void changeText() {
        CharSequence text = tvLeft.getText();
        tvLeft.setText(tvRight.getText());
        tvRight.setText(text);

        Drawable background = tvLeft.getBackground();
        tvLeft.setBackground(tvRight.getBackground());
        tvRight.setBackground(background);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                changeText();
                break;
        }
    }

    private View.OnClickListener myClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            changeText();
        }
    };

}