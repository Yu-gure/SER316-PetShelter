package petshelter.states;

import petshelter.animals.Animal;

/**
 * State representing an animal ready for adoption.
 */
public class AvailableState implements AnimalState {

    @Override
    public void handle(Animal animal) {
        System.out.println("Animal " + animal.getId() + " is available for adoption.");

        // Transition to next lifecycle state
        animal.setState(new PendingAdoptionState());
    }

    @Override
    public String getStatusName() {
        return "AVAILABLE";
    }
}
