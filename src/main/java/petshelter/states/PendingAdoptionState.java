package petshelter.states;

import petshelter.animals.Animal;

/**
 * State representing an animal that has a pending adoption.
 *
 * The animal has been selected by an adopter and is awaiting
 * final approval or completion of the adoption process.
 */
public class PendingAdoptionState implements AnimalState {

    @Override
    public void handle(Animal animal) {
        System.out.println("Animal " + animal.getId() + " has a pending adoption.");

        // Next lifecycle step
        animal.setState(new AdoptedState());
    }

    @Override
    public String getStatusName() {
        return "PENDING_ADOPTION";
    }
}