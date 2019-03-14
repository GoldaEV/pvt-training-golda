
package com.golda.app.pvttraining.dz6;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Students {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("gender")
    @Expose
    private Integer gender;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("people")
    @Expose
    private List<Person> people = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Students() {
    }

    /**
     * 
     * @param name
     * @param gender
     * @param date
     * @param people
     */
    public Students(String name, Integer gender, String date, List<Person> people) {
        super();
        this.name = name;
        this.gender = gender;
        this.date = date;
        this.people = people;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Students withName(String name) {
        this.name = name;
        return this;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Students withGender(Integer gender) {
        this.gender = gender;
        return this;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Students withDate(String date) {
        this.date = date;
        return this;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    public Students withPeople(List<Person> people) {
        this.people = people;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("name", name).append("gender", gender).append("date", date).append("people", people).toString();
    }

}
