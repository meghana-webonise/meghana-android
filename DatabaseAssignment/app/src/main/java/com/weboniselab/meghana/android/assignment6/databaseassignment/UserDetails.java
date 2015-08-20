package com.weboniselab.meghana.android.assignment6.databaseassignment;

/**
 * Created by webonise on 13/8/15.
 */
public class UserDetails {
    int age;
    String name;
    Double height,weight;
    public UserDetails(){
        this.name="";
        this.age=0;
        this.height=0.0;
        this.weight=0.0;

    }

    public UserDetails(String name,int age,Double height,Double weight){
        this.name=name;
        this.age=age;
        this.height=height;
        this.weight=weight;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name=name;
    }
    public int getAge(){
        return this.age;
    }
    public void setAge(int age){
        this.age=age;
    }
    public Double getHeight(){
        return this.height;
    }
    public void setHeight(Double height){
        this.height=height;
    }
    public Double getWeight(){
        return this.weight;
    }
    public void setWeight(Double weight){
        this.weight=weight;
    }
}
