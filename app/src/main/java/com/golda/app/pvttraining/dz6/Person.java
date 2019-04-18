package com.golda.app.pvttraining.dz6;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Person {

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("surname")
    @Expose
    private String surname;

    @SerializedName("age")
    @Expose
    private Integer age;

    @SerializedName("isDegree")
    @Expose
    private Boolean isDegree;

    @SerializedName("objectId")
    @Expose
    private String objectId;

    /**
     * No args constructor for use in serialization
     */
    public Person() {
    }

    /**
     * @param id
     * @param isDegree
     * @param age
     * @param name
     * @param surname
     */
    public Person(Integer id, String name, String surname, Integer age, Boolean isDegree) {
        super();
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.isDegree = isDegree;
    }

    public Person(String name, String surname, Integer age, Boolean isDegree, String objectId) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.isDegree = isDegree;
        this.objectId = objectId;
    }

    public Person(String name, String surname, Integer age, Boolean isDegree) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.isDegree = isDegree;
    }

    public Boolean getDegree() {
        return isDegree;
    }

    public void setDegree(Boolean degree) {
        isDegree = degree;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Person withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person withName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Person withSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Person withAge(Integer age) {
        this.age = age;
        return this;
    }

    public Boolean getIsDegree() {
        return isDegree;
    }

    public void setIsDegree(Boolean isDegree) {
        this.isDegree = isDegree;
    }

    public Person withIsDegree(Boolean isDegree) {
        this.isDegree = isDegree;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("name", name).append("surname", surname).append("age", age).append("isDegree", isDegree).toString();
    }

}
