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

    public Pet(String name, int age, double weight) throws PetError {
        this.name = name;

        // If age or weight are invalid, show an error and quit the whole program
        if((age < 0) || (weight < 0)) {
            throw new PetError("Negative age or weight");
        }

        this.age = age;
        this.weight = weight;
    }

    /**
     * Sets all the traits of a pet at once. If the new age or new weight is negative
     * it throws a PetError.
     *
     * @param newName A String containing the new pet name.
     * @param newAge A positive Integer for the new pet age.
     * @param newWeight A positive Double for the new pet weight.
     * @return Nothing.
     */
    public void setPet(String newName, int newAge, double newWeight) throws PetError {
        name = newName;
        if((newAge < 0) || (newWeight < 0)) {
            throw new PetError("Negative age or weight.");
        }
        weight = newWeight;
    }

    /**
     * Change the name of a pet to the given new name.
     *
     * @param newName String containing the new name.
     * @return Nothing.
     */
    public void setName(String newName) {
        name = newName;
    }

    /**
     * Changes the pet's age to the given new age. If it is negative,
     * it throws a PetError.
     *
     * @param newAge A positive Integer to set the age to.
     * @return Nothing.
     */
    public void setAge(int newAge) throws PetError {
        if(newAge < 0) {
            throw new PetError("Negative age.");
        }

        age = newAge;
    }

    /**
     * Changes the pet's age to the given new weight. If it is negative,
     * it throws a PetError.
     *
     * @param newWeight A positive double to set the new weight to.
     * @return Nothing.
     */
    public void setWeight(double newWeight) throws PetError {
        if(weight < 0) {
            throw new PetError("Negative weight.");
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
