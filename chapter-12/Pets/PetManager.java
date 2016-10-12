import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;
/*
 * Chapter 12
 * Project 4
 */
public class PetManager {
    public static ArrayList<Pet> pets = new ArrayList<>();

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        // Declare them once and reuse them so they aren't redefined each loop
        String name;
        int age;
        double weight;

        System.out.println("Enter pet info. When done, leave name empty.");

        while(true) {
            System.out.print("Name: ");
            name = userInput.nextLine();

            if(name.isEmpty())
                break;

            System.out.print("Age: ");
            age = userInput.nextInt();

            System.out.print("Weight: ");
            weight = userInput.nextDouble();

            if((age < 0) || (weight < 0)) {
                System.out.println("Invalid age or weight. Skipped.");
                userInput.nextLine();
                continue;
            }

            userInput.nextLine(); // For some weird bug that skips the next .nextLine()

            pets.add(new Pet(name, age, weight));
            System.out.println("Added pet!\n");
        }

        sortPetList();
        printPetList();
    }
    
    /**
     * Sorts the pet ArrayList by alphabetical order by pet name.
     * 
     * @return Nothing.
     */
    public static void sortPetList() {
        Collections.sort(pets, new Comparator<Pet>() {
            @Override
            public int compare(Pet a, Pet b) {
                return a.getName().compareTo(b.getName());
            }
        });
    }

    public static void printPetList() {
        System.out.println("\nAll Pets:");
        for(Object p : pets.toArray()) {
            Pet pet = (Pet)p;
            System.out.println("Name: " + pet.getName());
            System.out.println("Age: " + pet.getAge());
            System.out.println("Weight: " + pet.getWeight() + "\n");
        }
    }
}
