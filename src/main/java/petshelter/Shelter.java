package petshelter;

import petshelter.animals.Animal;
import java.util.ArrayList;
import java.util.List;

/**
 * Manages animals currently in the shelter.
 */
public class Shelter {

    private List<Animal> animals;

    public Shelter() {
        animals = new ArrayList<>();

        // R1.1 – initialize with five animals
        animals.add(new Animal("D007", "Dog", 2, "Healthy", "SZ-101"));
        animals.add(new Animal("C003", "Cat", 1, "Healthy", "SZ-102"));
        animals.add(new Animal("D006", "Dog", 5, "Injured", "SZ-103"));
        animals.add(new Animal("R008", "Rabbit", 3, "Healthy", "SZ-104"));
        animals.add(new Animal("B009", "Bird", 1, "Healthy", "SZ-105"));
    }

    public void intakeAnimal(Animal animal) {
        animals.add(animal);
    }

    public List<Animal> getAnimals() {
        return animals;
    }
}