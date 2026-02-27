package petshelter.states;

import petshelter.animals.Animal;

/**
 * State representing an animal ready for adoption.
 */
public class AvailableState implements AnimalState {

    @Override
    public void handle(Animal animal) {
        System.out.println("Animal " + animal.getId() + " is available for adoption.");
    }

    @Override
    public String getStatusName() {
        return "AVAILABLE";
    }
}
