
import java.util.ArrayList;
import serialisation.Animal;
import serialisation.Pet;
import serialisation.StoreList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author star_
 */
public class GUITest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        Animal myAnimal = new Pet("Polly", "Grey", "German", 10, "Umar", "Abid");
        Animal hisAnimal = new Pet("Rosi", "White", "Italian", 8, "Sikandar", "Butt");
        Pet myPet = new Pet("Mithu", "Green", "African", 1, "Joo", "Blogs");
        
        StoreList myStore = new StoreList(5);
        myStore.addAnimal(myAnimal);        
        myStore.addAnimal(hisAnimal);
        myStore.addAnimal(myPet);

        
        myStore.saveAnimals();
     
        
        // when you have the 
        
    }
    
}
