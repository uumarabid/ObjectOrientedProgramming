

package serialisation;
import java.util.ArrayList;
//import serialisation.Animal;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author star_
 */
public class StoreList  {
    private ArrayList<Animal> animalsToRegister;
    public final int MAX;
    
    public StoreList(int maxIn){
        animalsToRegister = new ArrayList<>();
        MAX = maxIn;
    }
    
    // adds a new animal to the list
    public boolean addAnimal(Animal theAnimal){
        if(!isFull()){
            animalsToRegister.add(theAnimal);
            return true;
        } else {
            return false;
        }
    }

    // tells the list is full
    private boolean isFull() {
        return animalsToRegister.size()== MAX;
    }
    //tells the list is empty
    public boolean isEmpty(){
        return animalsToRegister.isEmpty();
    }
    
    // total number of animals in the list
    
    public int getTotal(){
        return animalsToRegister.size();
    }
    
    // animal position in the lsit
    
    public Animal getAnimal(int positionIn){
        if(positionIn < 0 || positionIn >= getTotal()){
            return null;
        }
        else{
            return animalsToRegister.get(positionIn);
        }
    }
    
    // animal and owner in the lsit to be displayed
    
    public String displayAnimals(){
        String output = "\n";
        for (int counter = 0; counter < animalsToRegister.size(); counter++){
            output += animalsToRegister.get(counter).ownerGiveName + "\t" + 
                    animalsToRegister.get(counter).ownerSurname;
            output += animalsToRegister.get(counter).getName() + "\t" + 
                    animalsToRegister.get(counter).animalNumber + "\t" +
                    animalsToRegister.get(counter).registrationDate;
            output += "\n\n";
        }
        return output;
    }
    
}
