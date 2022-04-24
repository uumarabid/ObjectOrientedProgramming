package com.mycompany.surgeryapplication;

import java.io.Serializable;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Umar
 */
public class Animal implements Serializable {

    /**
     * instance variables (Encapsulation)Person and Locations classes
     */
    String type;
    String name;
    String colour;
    String gender;
    int age;
    String illnesses;
    String registrationDate;
    Person owner;
    Locations address;

    /**
     * constructor
     */
    public Animal(String theType, String theName, String theColour, String theGender, int theAge, String theIllnesses, Person theOwner, Locations theAddress) {
        type = theType;
        name = theName;
        colour = theColour;
        gender = theGender;
        age = theAge;
        illnesses = theIllnesses;
        owner = theOwner;
        address = theAddress;
    }

    /**
     *
     * @return
     */
    public Locations getAddress() {
        return address;
    }

    /**
     *
     * @param address
     */
    public void setAddress(Locations address) {
        this.address = address;
    }

    /**
     *
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     */
    public Person getOwner() {
        return owner;
    }

    /**
     *
     * @param owner
     */
    public void setOwner(Person owner) {
        this.owner = owner;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getColour() {
        return colour;
    }

    /**
     *
     * @param colour
     */
    public void setColour(String colour) {
        this.colour = colour;
    }

    /**
     *
     * @return
     */
    public String getGender() {
        return gender;
    }

    /**
     *
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    /**
     *
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     *
     * @return
     */
    public String getIllnesses() {
        return illnesses;
    }

    /**
     *
     * @param illnesses
     */
    public void setIllnesses(String illnesses) {
        this.illnesses = illnesses;
    }

    /**
     *
     * @return registrationDate
     */
    public String getRegistrationDate() {
        return registrationDate;
    }

    /**
     *
     * @param registrationDate
     */
    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    /**
     *
     */
    public void makeNoise() {
        System.out.println(name + " is making noise.");
    }

    public void eat() {
        System.out.println(name + " is eating fine.");
    }

    public void running() {
        System.out.println(name + "'s running is fine.");
    }
}
