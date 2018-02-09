package com.example.hanad.greenflagassignment1.model;

import io.realm.RealmObject;

/**
 * Created by hanad on 02/02/2018.
 * 1. Extend realm object
 * 2. create an empty contructor & Other Construstor
 * 3. Getters and Setters
 * 4. classname is TAble and Varaibles are columns
 * 5.Annotations and objects
 */

public class CustomerModel extends RealmObject {
    String name;
    String username;
    String password;
    String age;
    String birthday;
    String country;

    public CustomerModel(){

    }

    public CustomerModel(String name,String username, String password,String age, String birthday, String country) {
        this.name = name;
        this.username=username;
        this.age = age;
        this.birthday = birthday;
        this.password = password;
        this.country = country;
    }

    public String getPassword(){
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getAge(){
        return  age;
    }
    public void setAge(String age) {
        this.age = age;
    }

    public String getBirthday(){
        return birthday;
    }
    public void setBirthday(String birthday){
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getCountry(){return country;}
    public void setCountry(String country){this.country = country;}
}
