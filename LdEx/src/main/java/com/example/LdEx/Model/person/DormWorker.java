package com.example.LdEx.Model.person;

public class DormWorker extends Person{
    String job;
    double salary;
    int workDays;
    public DormWorker(int id, String name, String job, double salary, int workDaysPerWeek){
        super(id,name);
        this.job=job;
        this.salary=salary;
        this.workDays=workDaysPerWeek;
    }
}
