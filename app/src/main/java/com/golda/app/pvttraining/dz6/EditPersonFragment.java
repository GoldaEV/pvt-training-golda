package com.golda.app.pvttraining.dz6;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.golda.app.pvttraining.R;

public class EditPersonFragment extends Fragment {

    public static final String EXTRA_EDIT_ITEM = "EXTRA_EDIT_ITEM";

    private DataManager dataManager;
    private TextView label;
    private EditText name;
    private EditText surname;
    private EditText age;
    private CheckBox degree;
    private int editID = 0;
    private Button cancel;
    private Button save;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_person, container, false);

        dataManager = DataManager.getInstance();

//        Intent intent = getIntent();
//        editID = intent.getIntExtra(EXTRA_EDIT_ITEM, 0);
        label = view.findViewById(R.id.label);
        name = view.findViewById(R.id.editTextName);
        surname = view.findViewById(R.id.editTextSurname);
        age = view.findViewById(R.id.editTextAge);
        degree = view.findViewById(R.id.checkBoxDegree);
        save = view.findViewById(R.id.buttonSave);
        save.setOnClickListener(clickSave);
        cancel = view.findViewById(R.id.buttonCancel);
        cancel.setOnClickListener(clickCancel);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (editID == -1) {
            label.setText(R.string.new_person);
            save.setText(R.string.create);
        } else {
            name.setText(dataManager.getName(editID));
            surname.setText(dataManager.getSurname(editID));
            age.setText(String.valueOf(dataManager.getAge(editID)));
            degree.setChecked(dataManager.getIsDegree(editID));
        }
    }

    private void savePerson() {
        String sName = String.valueOf(name.getText());
        String sSurname = String.valueOf(surname.getText());
        int sAge = Integer.valueOf(String.valueOf(age.getText()));
        boolean sDegree = degree.isChecked();
        dataManager.editPerson(editID, sName, sSurname, sAge, sDegree);
//        finish();
    }

    private View.OnClickListener clickSave = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (editID == -1) {
                createPerson();
            } else {
                savePerson();
            }
        }
    };

    private void createPerson() {
        String sName = String.valueOf(name.getText());
        String sSurname = String.valueOf(surname.getText());
        int sAge = Integer.valueOf(String.valueOf(age.getText()));
        boolean sDegree = degree.isChecked();
        dataManager.createPerson(sName, sSurname, sAge, sDegree);
//        finish();
    }

    private View.OnClickListener clickCancel =new View.OnClickListener() {
        @Override
        public void onClick(View view) {
//            finish();
        }
    };
}
