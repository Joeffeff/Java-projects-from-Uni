package com.example.LdEx.Model.person;

public class Person {
    protected int id;
    protected String name;
    public Person(){}
    public Person(int id,String name){
        this.id=id;
        this.name=name;
    }
    public int getId(){return this.id;}
    public String getName(){return this.name;}

}
