package serialisation;

import java.io.*;

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
        Animal myAnimal;
        try {
            FileInputStream fileIn = new FileInputStream("./surgery.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);

            //read the information in as a object
            obj = in.readObject();
            //cast the object as an animal
            myAnimal = (Animal) obj;
            in.close();
            fileIn.close();
            System.out.println("Deserializing Animal...");
            System.out.println("Name of animal: " + myAnimal.name);
            System.out.println("Colour of animal: " + myAnimal.colour);
            System.out.println("Breed of animal: " + myAnimal.breed);
            System.out.println("Age of animal: " + myAnimal.age);
            System.out.println("Owner given name: " + myAnimal.ownerGiveName);
            System.out.println("Owner surname: " + myAnimal.ownerSurname);
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
