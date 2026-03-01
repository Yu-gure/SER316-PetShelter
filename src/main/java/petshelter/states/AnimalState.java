package petshelter.states;

import petshelter.animals.Animal;

/**
 * Interface for defining animal lifecycle states.
 *
 * Implementations represent different stages of an animal's shelter process
 * (e.g., Intake, Adoption, Medical, etc.).
 */

public interface AnimalState {
    void handle(Animal animal);
    String getStatusName();
}