package com.mycompany.surgeryapplication;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author star_
 */
public class Person {
    String ownerGiveName;
    String ownerSurname; 

    public Person(String ownerGiveName, String ownerSurname) {
        this.ownerGiveName = ownerGiveName;
        this.ownerSurname = ownerSurname;
    }

    public String getOwnerGiveName() {
        return ownerGiveName;
    }

    public void setOwnerGiveName(String ownerGiveName) {
        this.ownerGiveName = ownerGiveName;
    }

    public String getOwnerSurname() {
        return ownerSurname;
    }

    public void setOwnerSurname(String ownerSurname) {
        this.ownerSurname = ownerSurname;
    }
    
}
