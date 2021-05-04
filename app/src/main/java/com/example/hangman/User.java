package com.example.hangman;

public class User {
    String age;
    String name;
    boolean male;
    boolean female;

    public User(String age, String name, boolean male, boolean female) {
        this.age = age;
        this.name = name;
        this.male = male;
        this.female = female;
    }

    public String getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public boolean isMale() {
        return male;
    }

    public boolean isFemale() {
        return female;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public void setFemale(boolean female) {
        this.female = female;
    }
}
