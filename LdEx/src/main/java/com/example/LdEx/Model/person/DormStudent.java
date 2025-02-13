package com.example.LdEx.Model.person;

public class DormStudent extends Person{
    int kursas;
    String studyProgram;

    public DormStudent(int id, String name, String studyProgram, int kursas){
        super(id,name);
        this.studyProgram=studyProgram;
        this.kursas=kursas;
    }
}
