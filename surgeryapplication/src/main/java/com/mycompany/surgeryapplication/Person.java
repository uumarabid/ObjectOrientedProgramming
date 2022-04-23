package com.mycompany.surgeryapplication;

import java.io.Serializable;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author star_
 */
public class Person implements Serializable{
    String ownerGivenName;
    String ownerSurname; 

    public Person(String ownerGivenName, String ownerSurname) {
        this.ownerGivenName = ownerGivenName;
        this.ownerSurname = ownerSurname;
    }

    public String getOwnerGivenName() {
        return ownerGivenName;
    }

    public void setOwnerGivenName(String ownerGivenName) {
        this.ownerGivenName = ownerGivenName;
    }

    public String getOwnerSurname() {
        return ownerSurname;
    }

    public void setOwnerSurname(String ownerSurname) {
        this.ownerSurname = ownerSurname;
    }
    
}
