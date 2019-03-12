package com.golda.app.pvttraining.dz6;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.golda.app.pvttraining.R;

public class EditItemActivity extends Activity {
    public static final String EXTRA_EDIT_ITEM = "EXTRA_EDIT_ITEM";
    private DataManager dataManager;
    private EditText name;
    private EditText surname;
    private EditText age;
    private CheckBox degree;
    private int editID;
    private Button cancel;
    private Button save;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_edit_item);
        dataManager = DataManager.getInstance();

        Intent intent = getIntent();
        editID = intent.getIntExtra(EXTRA_EDIT_ITEM, 0);

        name = findViewById(R.id.editTextName);
        surname = findViewById(R.id.editTextSurname);
        age = findViewById(R.id.editTextAge);
        degree = findViewById(R.id.checkBoxDegree);
        save = findViewById(R.id.buttonSave);
        save.setOnClickListener(clickSave);
        cancel = findViewById(R.id.buttonCancel);
        cancel.setOnClickListener(clickCancel);
    }

    @Override
    protected void onResume() {
        super.onResume();

        name.setText(dataManager.getName(editID));
        surname.setText(dataManager.getSurname(editID));
        age.setText(String.valueOf(dataManager.getAge(editID)));
        degree.setChecked(dataManager.getIsDegree(editID));
    }


    private void saveData() {
        String sName = String.valueOf(name.getText());
        String sSurname = String.valueOf(surname.getText());
        int sAge = Integer.valueOf(String.valueOf(age.getText()));
        boolean sDegree = degree.isChecked();
        dataManager.editPerson(editID, sName, sSurname, sAge, sDegree);
        finish();
    }

    private View.OnClickListener clickSave = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            saveData();
        }
    };

    private View.OnClickListener clickCancel =new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            finish();
        }
    };

}

