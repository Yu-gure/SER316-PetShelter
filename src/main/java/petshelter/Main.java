package petshelter;


import petshelter.animals.Animal;

/**
 * Entry point for the Pet Shelter simulation.
 */
public class Main {

    public static void main(String[] args) {
        Shelter shelter = new Shelter();
        SimulationEngine engine = new SimulationEngine(shelter);

        engine.run(7);

        // quick little test
        Animal a = new Animal("11", "animal", 2, "Healthy", "SZ-000");

        //System.out.println(a.getStatusName()); // INTAKE
        //a.handleState();
        //System.out.println(a.getStatusName()); // AVAILABLE
    }
}