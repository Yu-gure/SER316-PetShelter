package petshelter.states;

import petshelter.animals.Animal;

/**
 * Represents the Intake state.
 *
 * Animals in this state have recently been admitted to the shelter
 * and are awaiting processing or evaluation.
 */

public class IntakeState implements AnimalState {

    @Override
    public void handle(Animal animal) {
        System.out.println("Animal " + animal.getId() + " is in intake.");
    }

    @Override
    public String getStatusName() {
        return "INTAKE";
    }
}
