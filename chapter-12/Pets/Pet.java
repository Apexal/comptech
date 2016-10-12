public class Pet {
    private String name;
    private int age;
    private double weight;

    // If no starting attributes are given, assign the defaults
    public Pet() {
        name = "Pet";
        age = 0;
        weight = 0;
    }

    public Pet(String name, int age, double weight) {
        this.name = name;

        // If age or weight are invalid, show an error and quit the whole program
        if((age < 0) || (weight < 0)) {
            System.out.println("Error: Negative age or weight!");
            System.exit(0);
        }

        this.age = age;
        this.weight = weight;
    }

    public void setPet(String newName, int newAge, double newWeight) {
        name = newName;
        if((newAge < 0) || (newWeight < 0)) {
            System.out.println("Error: Negative age or weight!");
            System.exit(0);
        }
        weight = newWeight;
    }
    
    /**
     * Change the name of a pet to the given new name.
     * @param newName String containing the new name.
     * @return Nothing.
     */
    public void setName(String newName) {
        name = newName;
    }
    
    /**
     * Changes the pet's age to the given new age. If it is negative, it print an error and quits the program.
     * 
     * @param newAge A positive Integer to set the age to.
     * @return Nothing.
     */
    public void setAge(int newAge) {
        if(newAge < 0) {
            System.out.println("Error: Negative age!");
            System.exit(0);
        }

        age = newAge;
    }
    
    /**
     * Changes the pet's age to the given new weight. If it is negative, it prints an error and quits the program.
     * 
     * @param newWeight A positive double to set the new weight to. 
     * @return Nothing.
     */
    public void setWeight(double newWeight) {
        if(weight < 0) {
            System.out.println("Error: Negative weight!");
            System.exit(0);
        }
        weight = newWeight;
    }
    
    /**
     * Get's the value of the pet's name.
     * 
     * @return String The pet's name.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Gets the value of the pet's age.
     * 
     * @return Integer The pet's age.
     */
    public int getAge() {
        return age;
    }
    
    /**
     * Gets the value of the pet's weight.
     * 
     * @return Double The pet's weight.
     */
    public double getWeight() {
        return weight;
    }

    public void writeOutput() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age + " years");
        System.out.println("Weight: " + weight + " pounds");
    }
}
