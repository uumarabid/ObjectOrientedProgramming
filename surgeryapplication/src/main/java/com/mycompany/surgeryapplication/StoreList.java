package com.mycompany.surgeryapplication;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Umar
 */
public class StoreList {

    private ArrayList<Animal> animalsToRegister;
    public final int MAX;

    /**
     * Constructor initialises the empty animal list and sets the maximum list
     * size
     *
     * @param maxIn The maximum number of animals in the list
     */
    public StoreList(int maxIn) {
        animalsToRegister = new ArrayList<>();
        MAX = maxIn;
    }

    /**
     * adds a new animal to the list
     *
     * @param theAnimal animal to add
     * @return Returns true if animal is added successfully and false otherwise
     */
    public boolean addAnimal(Animal theAnimal) {
        if (!isFull()) {
            animalsToRegister.add(theAnimal);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Tells if the list is full
     *
     * @return Returns true if the list is full and false otherwise
     */
    private boolean isFull() {
        return animalsToRegister.size() == MAX;
    }

    /**
     * Tells if the list is empty
     *
     * @return Returns true if the list is empty and false otherwise
     */
    public boolean isEmpty() {
        return animalsToRegister.isEmpty();
    }

    /**
     * Gets the total number of animals
     *
     * @return Returns the total number of animals currently in the list
     */
    public int getTotal() {
        return animalsToRegister.size();
    }

    /**
     * Read the animal at the given position in the list
     *
     * @param positionIn the position of the animal in the list
     * @return Returns the animal at the position in the list or null if no
     * animal at the logical position
     */
    public Animal getAnimal(int positionIn) {
        if (positionIn < 0 || positionIn >= getTotal()) {
            return null;
        } else {
            return animalsToRegister.get(positionIn);
        }
    }

    // animal and owner in the list to be displayed
    /**
     * Output all the animals in the list
     *
     * @return Returns all the animals and owners in the list in an easy to read
     * format
     */
    public String displayAnimals() {
        String output = "\n";
        for (int counter = 0; counter < animalsToRegister.size(); counter++) {
            output += animalsToRegister.get(counter).owner.ownerGivenName + "\t"
                    + animalsToRegister.get(counter).owner.ownerSurname + "\t";
            output += "Owner of: " + animalsToRegister.get(counter).getName() + "\t"
                    + " Colour: " + animalsToRegister.get(counter).colour + "\t"
                    + " Gender: " + animalsToRegister.get(counter).gender + "\n";
            output += " Age: " + animalsToRegister.get(counter).age + "\t"
                    + " Illness: " + animalsToRegister.get(counter).illnesses + "\t"
                    + " Type: " + animalsToRegister.get(counter).type;
            output += "\n\n";
        }
        return output;
    }

    // 
    /**
     * Deserialization
     *
     * @return Returns saved animals from surgery.txt file
     */
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

    /**
     * create an object for serialisation and pass the 
     * animalsToRegister SimpleDateFormat class, to get the registration date
     *
     * @return Returns true upon saving the data in /.surgery.txt file
     */
    public boolean saveAnimals() {

        try {
            ArrayList<Animal> loadedAnimals = loadAnimal();
            for (int i = 0; i < animalsToRegister.size(); i++) {
                Animal item = animalsToRegister.get(i);

                // used the code for time from https://stackabuse.com/how-to-get-current-date-and-time-in-java/
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
                Date date = new Date(System.currentTimeMillis());
                item.registrationDate = formatter.format(date);

                loadedAnimals.add(item);
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
