package petshelter.states;

import petshelter.animals.Animal;

/**
 * State representing an animal that has been adopted.
 * <p>
 * This is the final state in the animal lifecycle.
 */
public class AdoptedState implements AnimalState {

    @Override
    public void handle(Animal animal) {
        System.out.println("Animal " + animal.getId() + " has been adopted.");
        // Final state — no transition
    }

    @Override
    public String getStatusName() {
        return "ADOPTED";
    }
}