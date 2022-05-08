package com.mycompany.surgeryapplication;

import java.io.Serializable;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Umar
 * @version 1.0
 */
public class Person implements Serializable {

    String ownerGivenName;
    String ownerSurname;

    public Person(String ownerGivenName, String ownerSurname) {
        this.ownerGivenName = ownerGivenName;
        this.ownerSurname = ownerSurname;
    }

    /**
     *
     * @return owner first name
     */
    public String getOwnerGivenName() {
        return ownerGivenName;
    }

    /**
     *
     * @param ownerGivenName
     */
    public void setOwnerGivenName(String ownerGivenName) {
        this.ownerGivenName = ownerGivenName;
    }

    /**
     *
     * @return owner surname
     */
    public String getOwnerSurname() {
        return ownerSurname;
    }

    /**
     *
     * @param ownerSurname
     */
    public void setOwnerSurname(String ownerSurname) {
        this.ownerSurname = ownerSurname;
    }

}
