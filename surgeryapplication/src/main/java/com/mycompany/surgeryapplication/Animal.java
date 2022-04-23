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
public class Animal implements Serializable {
    String type;
    String name;
    String colour;
    String gender;
    int age;
    String illnesses;
    String registrationDate;
    Person owner;

    
    // constructor
    public Animal(String theType, String theName, String theColour, String theGender, int theAge, String theIllnesses, Person theOwner){
        type = theType;
        name = theName;
        colour = theColour;
        gender = theGender;
        age = theAge;
        illnesses = theIllnesses;
        owner = theOwner;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIllnesses() {
        return illnesses;
    }

    public void setIllnesses(String illnesses) {
        this.illnesses = illnesses;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }
    
    
    public void makeNoise(){
        System.out.println(name + " is making noise.");
    }
    
    public void eat(){
        System.out.println(name + " is eating fine.");
    }
    
    public void running(){
        System.out.println(name + "'s running is fine.");
    }
}
