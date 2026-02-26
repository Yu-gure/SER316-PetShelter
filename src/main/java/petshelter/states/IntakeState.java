package petshelter.states;

import petshelter.animals.Animal;

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
