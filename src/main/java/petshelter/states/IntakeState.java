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
        System.out.println("Animal has " + animal.getId() + " completed intake.");

        // Transition to next lifecycle state
        animal.setState(new AvailableState());
    }

    @Override
    public String getStatusName() {
        return "INTAKE";
    }


}
