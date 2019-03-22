package com.golda.app.pvttraining.dz6;

import android.app.Activity;
import android.content.Context;
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
import android.widget.Toast;

import com.golda.app.pvttraining.R;

public class EditPersonFragment extends Fragment {

    private DataManager dataManager;
    private TextView label;
    private EditText name;
    private EditText surname;
    private EditText age;
    private CheckBox degree;
    private int editID = 0;
    private Button cancel;
    private Button save;
    private Activity activity;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_person, container, false);

        dataManager = DataManager.getInstance();


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
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (Activity) context;
    }

    private void displayPerson(Person person) {
        name.setText(person.getName());
        surname.setText(person.getSurname());
        age.setText(String.valueOf(person.getAge()));
        degree.setChecked(person.getIsDegree());
    }

    private void savePerson() {
        String sName = String.valueOf(name.getText());
        String sSurname = String.valueOf(surname.getText());
        int sAge = Integer.valueOf(String.valueOf(age.getText()));
        boolean sDegree = degree.isChecked();
        dataManager.editPerson(editID, sName, sSurname, sAge, sDegree);
        Toast.makeText(activity, sName + " saved", Toast.LENGTH_SHORT).show();
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
        Toast.makeText(activity, sName + " created", Toast.LENGTH_SHORT).show();
    }


    private View.OnClickListener clickCancel =new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            try {
                ((FragmentCloser) activity).close();
            } catch (ClassCastException e) {
            }

        }
    };


    public void displayDetails(int id) {
        editID = id;
        if (editID == -1) {
            label.setText(R.string.new_person);
            save.setText(R.string.create);
        } else {
            displayPerson(dataManager.getPersonById(id));
        }
    }

    public interface FragmentCloser {
        void close();
    }


}

