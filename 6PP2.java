🛠 PRACTICE PROBLEM 2: Multilevel Inheritance Chain
Building deep inheritance hierarchies with proper constructor chaining
// File: MultilevelInheritanceDemo.java
// TODO: Create base class Animal:
public class Animal {
// TODO: Create protected fields:
// - species (String)
// - habitat (String)
// - lifespan (int)
// - isWildlife (boolean)
// TODO: Create constructor that:
// - Takes all parameters
// - Prints "Animal constructor: Creating [species]"
// TODO: Create methods:
// - eat() - prints "Animal is eating"
// - sleep() - prints "Animal is sleeping"

3

// - move() - prints "Animal is moving"
// - getAnimalInfo() - returns formatted animal details
}
// TODO: Create intermediate class Mammal extends Animal:
public class Mammal extends Animal {
// TODO: Add mammal-specific fields:
// - furColor (String)
// - hasWarmBlood (boolean) - always true for mammals
// - gestationPeriod (int) - days
// TODO: Create constructor that:
// - Takes Animal parameters plus mammal-specific parameters
class Animal {
    protected String species;
    protected String habitat;
    protected int lifespan;
    protected boolean isWildlife;

    public Animal(String species, String habitat, int lifespan, boolean isWildlife) {
        this.species = species;
        this.habitat = habitat;
        this.lifespan = lifespan;
        this.isWildlife = isWildlife;
        System.out.println("Animal constructor: Creating " + species);
    }

    public void eat() {
        System.out.println("Animal is eating");
    }

    public void sleep() {
        System.out.println("Animal is sleeping");
    }

    public void move() {
        System.out.println("Animal is moving");
    }

    public String getAnimalInfo() {
        return "Species: " + species + ", Habitat: " + habitat +
               ", Lifespan: " + lifespan + " years, Wildlife: " + isWildlife;
    }
}

class Mammal extends Animal {
    protected String furColor;
    protected boolean hasWarmBlood;
    protected int gestationPeriod;

    public Mammal(String species, String habitat, int lifespan, boolean isWildlife,
                  String furColor, int gestationPeriod) {
        super(species, habitat, lifespan, isWildlife);
        this.furColor = furColor;
        this.hasWarmBlood = true;
        this.gestationPeriod = gestationPeriod;
        System.out.println("Mammal constructor: Adding mammal traits");
    }

    @Override
    public void move() {
        super.move();
        System.out.println("Mammal is walking/running");
    }

    public void nurse() {
        System.out.println("Mammal is nursing offspring");
    }

    public void regulateTemperature() {
        System.out.println("Maintaining body temperature");
    }
}

public class Dog extends Mammal {
    private String breed;
    private boolean isDomesticated;
    private int loyaltyLevel;
    private String favoriteActivity;

    public Dog() {
        super("Canine", "Domestic", 12, false, "Various", 60);
        this.breed = "Mixed";
        this.isDomesticated = true;
        this.loyaltyLevel = 5;
        this.favoriteActivity = "Playing";
        System.out.println("Dog constructor: Creating default dog");
    }

    public Dog(String species, String habitat, int lifespan, boolean isWildlife,
               String furColor, int gestationPeriod,
               String breed, boolean isDomesticated, int loyaltyLevel, String favoriteActivity) {
        super(species, habitat, lifespan, isWildlife, furColor, gestationPeriod);
        this.breed = breed;
        this.isDomesticated = isDomesticated;
        this.loyaltyLevel = loyaltyLevel;
        this.favoriteActivity = favoriteActivity;
        System.out.println("Dog constructor: Creating " + breed + " dog");
    }

    public Dog(Dog other) {
        this(other.species, other.habitat, other.lifespan, other.isWildlife,
             other.furColor, other.gestationPeriod,
             other.breed, other.isDomesticated, other.loyaltyLevel, other.favoriteActivity);
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("Dog is wagging tail while eating");
    }

    @Override
    public void move() {
        System.out.println("Dog is running and playing");
    }

    @Override
    public void sleep() {
        System.out.println("Dog is sleeping in doghouse");
    }

    public void bark() {
        System.out.println("Woof! Woof!");
    }

    public void fetch() {
        System.out.println("Dog is fetching the ball");
    }

    public void showLoyalty() {
        System.out.println("Dog loyalty level: " + loyaltyLevel + "/10");
    }

    public void demonstrateInheritance() {
        super.eat();
        super.move();
        super.sleep();
        this.bark();
    }

    public static void main(String[] args) {
        System.out.println("=== Default Constructor Test ===");
        Dog dog1 = new Dog();
        dog1.eat();
        dog1.move();
        dog1.sleep();
        dog1.bark();
        dog1.fetch();
        dog1.showLoyalty();
        System.out.println(dog1.getAnimalInfo());

        System.out.println("\n=== Parameterized Constructor Test ===");
        Dog dog2 = new Dog("Canine", "Domestic", 15, false, "Brown", 65,
                           "Labrador", true, 9, "Swimming");
        dog2.eat();
        dog2.move();
        dog2.sleep();
        dog2.showLoyalty();

        System.out.println("\n=== Copy Constructor Test ===");
        Dog dog3 = new Dog(dog2);
        dog3.fetch();
        dog3.bark();

        System.out.println("\n=== Inheritance Demo ===");
        System.out.println("dog2 instanceof Dog: " + (dog2 instanceof Dog));
        System.out.println("dog2 instanceof Mammal: " + (dog2 instanceof Mammal));
        System.out.println("dog2 instanceof Animal: " + (dog2 instanceof Animal));
    }
}
