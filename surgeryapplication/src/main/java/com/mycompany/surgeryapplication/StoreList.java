package com.mycompany.surgeryapplication;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
            output += animalsToRegister.get(counter).getName() + "\t"
                    + animalsToRegister.get(counter).colour + "\t"
                    + animalsToRegister.get(counter).gender + "\t";
            output += animalsToRegister.get(counter).age + "\t"
                    + animalsToRegister.get(counter).illnesses;
            output += "\n\n";
        }
        return output;
    }
    //create a save method 
    // call serialize class here and pass the animalsToRegister

    public boolean saveAnimals() {

        try {
            FileOutputStream fileOut = new FileOutputStream("./surgery.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(animalsToRegister);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in ./surgery.txt file");
        } catch (IOException myException) {
            myException.printStackTrace();
        }
        return true;
    }
}
