package com.weboniselab.meghana.android.assignment6.fragmentandroidassignment;

/**
 * Created by webonise on 20/8/15.
 */
public class PersonDetails {
    int age,id;
    String name;
    Double height,weight;
    public PersonDetails(){
        this.id=0;
        this.name="";
        this.age=0;
        this.height=0.0;
        this.weight=0.0;
    }
    public PersonDetails(int id,String name,int age,Double height,Double weight){
        this.id=id;
        this.name=name;
        this.age=age;
        this.height=height;
        this.weight=weight;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
}