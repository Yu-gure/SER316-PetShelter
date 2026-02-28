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
    private static final String DEFAULT_ZONE_CODE = "SZ-000";

    // Default constructor
    public Animal() {
        this.id = "";
        this.species = "";
        this.age = 0;
        this.healthStatus = "";
        this.shelterZoneCode = DEFAULT_ZONE_CODE;
        this.state = new IntakeState();
    }

    //  constructor
    public Animal(String id, String species, int age, String healthStatus, String shelterZoneCode) {
        setId(id);
        setSpecies(species);
        setAge(age);
        setHealthStatus(healthStatus);
        setShelterZoneCode(shelterZoneCode);
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

    public void setShelterZoneCode(String shelterZoneCode) {
        if (shelterZoneCode == null || shelterZoneCode.isBlank()) {
            throw new IllegalArgumentException("Shelter zone code cannot be blank");
        }

        // Must start with SZ-
        if (!shelterZoneCode.startsWith("SZ-")) {
            throw new IllegalArgumentException("Shelter zone must start with SZ-");
        }

        // Must be length 6 (SZ- + 3 digits)
        if (shelterZoneCode.length() != 6) {
            throw new IllegalArgumentException("Shelter zone must be in format SZ-XXX");
        }

        // Check digits
        String numberPart = shelterZoneCode.substring(3);
        for (char c : numberPart.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("Shelter zone must contain digits after SZ-");
            }
        }

        this.shelterZoneCode = shelterZoneCode;
    }

    public void setHealthStatus(String healthStatus) {
        if (healthStatus == null || healthStatus.isBlank()) {
            throw new IllegalArgumentException("Health status cannot be blank");
        }
        this.healthStatus = healthStatus;
    }

    public void setState(AnimalState state) {

        //thought of adding null logic for this
        if (state == null) {
            throw new IllegalArgumentException("State cannot be null");
        }

        this.state = state;

    }

    public void handleState() {
        state.handle(this);
    }
}
