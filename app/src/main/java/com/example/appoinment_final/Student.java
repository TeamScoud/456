package com.example.appoinment_final;

import javax.security.auth.Subject;

public class Student {

    private String ID;
    private String Name;
    private String Subject;
    private String Date;
    private String Mode;


    public Student() {

    }


    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }



    public String getSubject() {
        return Subject;
    }


    public void setSubject(String subject) {
        Subject = subject;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getMode() {
        return Mode;
    }

    public void setMode(String mode) {
        Mode = mode;
    }
}
