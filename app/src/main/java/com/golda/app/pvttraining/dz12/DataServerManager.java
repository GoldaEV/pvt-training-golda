package com.golda.app.pvttraining.dz12;

import com.golda.app.pvttraining.dz6.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataServerManager {
    private static final DataServerManager ourInstance = new DataServerManager();
    private ChangeListener changeListener;
    private List<Person> personList;


    public void setChangeListener(ChangeListener changeListener) {
        this.changeListener = changeListener;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public static DataServerManager getInstance() {
        return ourInstance;
    }

    private DataServerManager() {
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

    public void editPerson(Person person) {
        new PersonUpdater().updateItem(person);
        if (changeListener !=null) changeListener.onChanged();
    }

    public boolean isListEmpty() {
        return personList.isEmpty();
    }

    public void removeItem(Person item) {
        new PersonRemover().removeItem(item);
        if (changeListener !=null) changeListener.onChanged();
    }


    public void createItem(Person person) {
        new PersonCreator().createItem(person);
        if (changeListener != null) changeListener.onChanged();
    }

    public Person getPersonById(String id) {
        Person person = new Person();
        for (Person per : personList) {
            if (per.getObjectId().equals(id)) {
                person = per;
            }
        }
        return person;
    }

    public void getPersons() {
        new PersonsLoader().loadData();
    }

    public interface ChangeListener {
        void onChanged();
    }

}
