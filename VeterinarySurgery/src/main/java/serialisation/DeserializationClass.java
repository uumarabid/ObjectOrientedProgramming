package serialisation;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author star_
 */
public class DeserializationClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Object obj;
        ArrayList<Animal> myAnimal;
        
        try {
            FileInputStream fileIn = new FileInputStream("./surgery.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);

            //read the information in as a object
            obj = in.readObject();
            //cast the object as an animal
            myAnimal = (ArrayList<Animal>) obj;
            in.close();
            fileIn.close();
            for (int i = 0; i < myAnimal.size(); i++) {
                Animal item = myAnimal.get(i);
                System.out.println("Deserializing Animal...");
                System.out.println("Name of animal: " + item.name);
                System.out.println("Colour of animal: " + item.colour);
                System.out.println("Breed of animal: " + item.breed);
                System.out.println("Age of animal: " + item.age);
                System.out.println("Owner given name: " + item.ownerGiveName);
                System.out.println("Owner surname: " + item.ownerSurname);                
                System.out.println("-------------");

            }
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Animal class not Found");
            c.printStackTrace();
            return;
        }
    }

}
