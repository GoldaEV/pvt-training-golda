package com.golda.app.pvttraining.dz6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataManager {
    private static final DataManager ourInstance = new DataManager();
    private ChangeListener changeListener;
    private List<Person> personList;


    public void setChangeListener(ChangeListener changeListener) {
        this.changeListener = changeListener;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public static DataManager getInstance() {
        return ourInstance;
    }

    private DataManager() {
        personList = new ArrayList<>();
    }

    public void setPersons(List<Person> people) {
        personList.clear();
        personList.addAll(people);
        if (changeListener !=null) changeListener.onChanged();
    }

    public String getName(int editID) {
        String name = "";
        for (Person person : personList) {
            if (person.getId() == editID) {
                name = person.getName();
            }
        }
        return name;
    }

    public String getSurname(int editID) {
        String surname = "";
        for (Person person : personList) {
            if (person.getId() == editID) {
                surname = person.getSurname();
            }
        }
        return surname;
    }

    public int getAge(int editID) {
        int age = 0;
        for (Person person : personList) {
            if (person.getId() == editID) {
                age = person.getAge();
            }
        }
        return age;
    }

    public boolean getIsDegree(int editID) {
        boolean degree = false;
        for (Person person : personList) {
            if (person.getId() == editID) {
                degree = person.getIsDegree();
            }
        }
        return degree;
    }

    public void editPerson(int editID, String sName, String sSurname, int sAge, boolean sDegree) {
        for (Person person : personList) {
            if (person.getId() == editID) {
                person.setName(sName);
                person.setSurname(sSurname);
                person.setAge(sAge);
                person.setIsDegree(sDegree);
                if (changeListener !=null) changeListener.onChanged();
            }
        }

    }

    public boolean isListEmpty() {
        return personList.isEmpty();
    }

    public void removeItem(Person item) {
        personList.remove(item);
        if (changeListener !=null) changeListener.onChanged();
    }

    public void createPerson(String sName, String sSurname, int sAge, boolean sDegree) {
        int newID = new Random().nextInt();
        Person person = new Person(newID, sName, sSurname, sAge, sDegree);
        personList.add(person);
        if (changeListener != null) changeListener.onChanged();
    }

    public Person getPersonById(int id) {
        Person person = new Person();
        for (Person per : personList) {
            if (per.getId() == id) {
                person = per;
            }
        }
        return person;
    }

    public interface ChangeListener {
        void onChanged();
    }

}
