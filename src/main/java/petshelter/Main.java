package petshelter;


/**
 * Entry point for the Pet Shelter simulation.
 */
public class Main {

    public static void main(String[] args) {
        Shelter shelter = new Shelter();
        SimulationEngine engine = new SimulationEngine(shelter);

        engine.run(7);
    }
}