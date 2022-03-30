package serialisation;
import java.io.Serializable;
import java.time.LocalDate;
import java.lang.Math;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author star_
 */
public class Animal implements Serializable {
    String name;
    String colour;
    String breed;
    int age;
    String ownerGiveName;
    String ownerSurname;
    int animalNumber;
    LocalDate registrationDate;
    private static final long serialVersionUID = 546222361;
     

    
    // constructor
    public Animal(String theName, String theColour, String theBreed, int theAge, String theOwnerGiveName, String theOwnerSurname){
        name = theName;
        colour = theColour;
        breed = theBreed;
        age = theAge;
        ownerSurname = theOwnerGiveName;
        ownerGiveName = theOwnerSurname;
        animalNumber = (int) (Math.random() * 10000);
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

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAnimalNumber() {
        return animalNumber;
    }

    public void setAnimalNumber(int animalNumber) {
        this.animalNumber = animalNumber;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
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
