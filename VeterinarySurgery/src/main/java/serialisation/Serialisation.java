package serialisation;

import java.io.*;
import java.util.ArrayList;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.ObjectOutputStream;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author star_
 */
public class Serialisation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         ArrayList<Animal> animals = new ArrayList<Animal>();
        
        Animal myAnimal = new Pet("Polly", "Grey", "Female", 10, "Flue", "Umar", "Abid");
        Animal hisAnimal = new Pet("Rosi", "White", "Female", 8, "Cough", "Sikandar", "Butt");
        Pet myPet = new Pet("Mithu", "Green", "Male", 1, "Flue", "Joo", "Blogs");
        
        animals.add(myAnimal);        
        animals.add(hisAnimal);        
        animals.add(myPet);

        try {
            FileOutputStream fileOut = new FileOutputStream("./surgery.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(animals);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in ./surgery.txt file");
        } catch (IOException myException) {
            myException.printStackTrace();
        }
    }

}
