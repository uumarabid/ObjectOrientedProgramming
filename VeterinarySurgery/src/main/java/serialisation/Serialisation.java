package serialisation;

import java.io.*;
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
        Animal myAnimal = new Animal("Polly", "Grey", "German", 10, "Umar", "Abid");

        try {
            FileOutputStream fileOut = new FileOutputStream("./surgery.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(myAnimal);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in ./surgery.txt file");
        } catch (IOException myException) {
            myException.printStackTrace();
        }
    }

}
