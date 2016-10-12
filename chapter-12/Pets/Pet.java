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

    public void setName(String newName) {
        name = newName;
    }

    public void setAge(int newAge) {
        if(newAge < 0) {
            System.out.println("Error: Negative age!");
            System.exit(0);
        }

        age = newAge;
    }

    public void setWeight(double newWeight) {
        weight = newWeight;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public void writeOutput() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age + " years");
        System.out.println("Weight: " + weight + " pounds");
    }
}
