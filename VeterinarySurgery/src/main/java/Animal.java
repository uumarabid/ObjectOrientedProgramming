
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
public class Animal {
    String name;
    String colour;
    String breed;
    int age;
    int animalNumber;
    LocalDate registrationDate;
    
    // constructor
    public Animal(String theName, String theColour, String theBreed, int theAge ){
        name = theName;
        colour = theColour;
        age = theAge;
        breed = theBreed;
        animalNumber = (int) (Math.random() * 10000);
    }
    
    //methods
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
