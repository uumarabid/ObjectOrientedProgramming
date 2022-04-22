package com.mycompany.surgeryapplication;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
//import serialisation.Animal;

public class StoreList {

    private ArrayList<Animal> animalsToRegister;
    public final int MAX;

    public StoreList(int maxIn) {
        animalsToRegister = new ArrayList<>();
        MAX = maxIn;
    }

    // adds a new animal to the list
    public boolean addAnimal(Animal theAnimal) {
        if (!isFull()) {
            animalsToRegister.add(theAnimal);
            return true;
        } else {
            return false;
        }
    }

    // tells the list is full
    private boolean isFull() {
        return animalsToRegister.size() == MAX;
    }

    //tells the list is empty
    public boolean isEmpty() {
        return animalsToRegister.isEmpty();
    }

    // total number of animals in the list
    public int getTotal() {
        return animalsToRegister.size();
    }

    // animal position in the lsit
    public Animal getAnimal(int positionIn) {
        if (positionIn < 0 || positionIn >= getTotal()) {
            return null;
        } else {
            return animalsToRegister.get(positionIn);
        }
    }

    // animal and owner in the lsit to be displayed
    public String displayAnimals() {
        String output = "\n";
        for (int counter = 0; counter < animalsToRegister.size(); counter++) {
            output += animalsToRegister.get(counter).ownerGiveName + "\t"
                    + animalsToRegister.get(counter).ownerSurname + "\t";
            output += "Owner of: " + animalsToRegister.get(counter).getName() + "\t"
                    + " Colour: " + animalsToRegister.get(counter).colour + "\t"
                    + " Gender: " + animalsToRegister.get(counter).gender + "\t";
            output += " Age: " + animalsToRegister.get(counter).age + "\t"
                    + " Illness: " + animalsToRegister.get(counter).illnesses + "\t"
                    + " Type: " + animalsToRegister.get(counter).type + "\t";
            output += "\n\n";
        }
        return output;
    }

    // deserialize
    public ArrayList<Animal> loadAnimal() {
        Object obj;
        ArrayList<Animal> loadedAnimals = new ArrayList<>();
        if (Files.exists(Paths.get("./surgery.txt"))) {
            try {
                FileInputStream fileIn = new FileInputStream("./surgery.txt");
                ObjectInputStream in = new ObjectInputStream(fileIn);

                obj = in.readObject();
                loadedAnimals = (ArrayList<Animal>) obj;
                in.close();
                fileIn.close();
            } catch (IOException i) {
                i.printStackTrace();
            } catch (ClassNotFoundException c) {
                System.out.println("Animal class not found");
                c.printStackTrace();
            }
        }
        return loadedAnimals;
    }

    //create a save method 
    // call serialize class here and pass the animalsToRegister
     
    public boolean saveAnimals() {

        try {
            ArrayList<Animal> loadedAnimals = loadAnimal();
            for(int i = 0; i < animalsToRegister.size(); i++){
                loadedAnimals.add(animalsToRegister.get(i));
            }
            FileOutputStream fileOut = new FileOutputStream("./surgery.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(loadedAnimals);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in ./surgery.txt file");
        } catch (IOException myException) {
            myException.printStackTrace();
        }
        return true;
    }
}
