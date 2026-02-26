package petshelter.states;

import petshelter.animals.Animal;

public interface AnimalState {
    void handle(Animal animal);
    String getStatusName();
}