package petshelter;

import petshelter.animals.Animal;

/**
 * Runs the pet shelter simulation in daily cycles.
 */
public class SimulationEngine {

    private final Shelter shelter;

    public SimulationEngine(Shelter shelter) {
        this.shelter = shelter;
    }

    /**
     * Runs the simulation for the given number of days.
     *
     * @param days number of cycles to run (must be positive)
     * @throws IllegalArgumentException if days <= 0
     */
    public void run(int days) {
        if (days <= 0) {
            throw new IllegalArgumentException("Days must be positive");
        }

        for (int day = 1; day <= days; day++) {
            System.out.println("SIMS " + toRoman(day));

            // Minimal output: show current animals and their statuses
            for (Animal animal : shelter.getAnimals()) {
                System.out.println(animal.getId() + " - " + animal.getSpecies()
                        + " - " + animal.getStatusName() + " - " + animal.getShelterZoneCode());
            }

            System.out.println(); // blank line between cycles
        }
    }

    /**
     * Converts a small positive integer (1-10) into a Roman numeral.
     *
     * @param number value to convert
     * @return Roman numeral string
     * @throws IllegalArgumentException if number is not between 1 and 10
     */
    public String toRoman(int number) {
        return switch (number) {
            case 1 -> "I";
            case 2 -> "II";
            case 3 -> "III";
            case 4 -> "IV";
            case 5 -> "V";
            case 6 -> "VI";
            case 7 -> "VII";
            case 8 -> "VIII";
            case 9 -> "IX";
            case 10 -> "X";
            default -> throw new IllegalArgumentException("Roman conversion supports 1 to 10 only");
        };
    }
}