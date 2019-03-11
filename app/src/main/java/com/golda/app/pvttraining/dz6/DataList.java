package com.golda.app.pvttraining.dz6;

import java.util.ArrayList;
import java.util.List;

public class DataList {
    private static final DataList ourInstance = new DataList();

    public List<Person> getPersonList() {
        return personList;
    }

    private List<Person> personList;

    public static DataList getInstance() {
        return ourInstance;
    }

    private DataList() {
        personList = new ArrayList<>();
    }

    public void setPersons(List<Person> people) {
        personList.clear();
        personList.addAll(people);
    }
}
