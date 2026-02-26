package petshelter.animals;

import petshelter.states.AnimalState;
import petshelter.states.IntakeState;

/**
 * Represents an animal in the shelter system.
 *
 * Each animal stores identifying information, health status, shelter location,
 * and a current state representing its lifecycle within the shelter.
 *
 * The class supports the State design pattern to manage status transitions.
 */

public class Animal {

    protected String id;
    protected String species;
    protected int age;
    protected String healthStatus;
    protected String shelterZoneCode;
    protected AnimalState state;

    // Default constructor
    public Animal() {
        this.id = "";
        this.species = "";
        this.age = 0;
        this.healthStatus = "";
        this.shelterZoneCode = "SZ-000";
        this.state = new IntakeState();
    }

    //  constructor
    public Animal(String id, String species, int age, String healthStatus, String shelterZoneCode) {
        setId(id);
        setSpecies(species);
        setAge(age);
        this.state = new IntakeState();
    }

    // Getters

    public String getId() {
        return id;
    }

    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }

    public String getHealthStatus() {
        return healthStatus;
    }

    public String getShelterZoneCode() {
        return shelterZoneCode;
    }

    public AnimalState getState() {
        return state;
    }

    public String getStatusName() {
        return state.getStatusName();
    }

    // Setters with validation
    // Setters with validation

    public void setId(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Animal ID cannot be blank");
        }
        this.id = id;
    }

    public void setSpecies(String species) {
        if (species == null || species.isBlank()) {
            throw new IllegalArgumentException("Species cannot be blank");
        }
        this.species = species;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        this.age = age;
    }

    public void setState(AnimalState state) {
        this.state = state;
    }

    public void handleState() {
        state.handle(this);
    }

}