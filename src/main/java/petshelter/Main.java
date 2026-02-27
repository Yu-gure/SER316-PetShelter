package petshelter;

import petshelter.animals.Animal;

public class Main {

    public static void main(String[] args) {
        Shelter shelter = new Shelter();

        System.out.println("SIMS I");

        for (Animal animal : shelter.getAnimals()) {
            System.out.println(
                    animal.getId() + " - " +
                            animal.getSpecies() + " - " +
                            animal.getStatusName()
            );
        }
    }
}