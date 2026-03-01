package petshelter;

import petshelter.animals.Animal;
import petshelter.people.AdoptionCounselor;
import petshelter.people.Staff;
import petshelter.people.VetTech;
import petshelter.people.Veterinarian;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Runs the pet shelter simulation in daily cycles.
 */
public class SimulationEngine {

    private final Shelter shelter;
    private final Random rng = new Random();
    private final List<Staff> staff = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public SimulationEngine(Shelter shelter) {
        this.shelter = shelter;
        //add staff
        staff.add(new Veterinarian("V001", "Dr. Chen"));
        staff.add(new VetTech("T001", "Morgan"));
        staff.add(new AdoptionCounselor("A001", "Riley"));

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
            System.out.println("SIM " + toRoman(day));

            // 30% chance of a new arrival each day
            if (rng.nextInt(100) < 30) {
                Animal newAnimal = new Animal("N" + day + "-" + rng.nextInt(100),
                        "Dog", 1, "Healthy", "SZ-106");
                shelter.intakeAnimal(newAnimal);
                System.out.println("New arrival: " + newAnimal.getId());
            }

            //show current animals and their statuses
            for (Animal animal : shelter.getAnimals()) {
                System.out.println(animal.getId() + " - " + animal.getSpecies()
                        + " - " + animal.getStatusName() + " - " + animal.getShelterZoneCode());

                // Advance lifecycle each day
                // 70% chance the animal advances today
                if (rng.nextInt(100) < 70) {
                    animal.handleState();
                }

            }
            System.out.println("\nPress ENTER to run next day...");
            scanner.nextLine();
            System.out.println();
        }
    }

    /**
     *Organize the roman numerals instead of typing them out one by one.
     *Used by the simulation cycle output (SIMS I, SIMS II, etc.).
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


    //helper methods for picking staff and first available to assign these people
    private Staff pickStaffForTask(String task) {
        // super simple routing:
        if (task.equals("Intake exam")) return firstAvailable("Veterinarian");
        if (task.equals("Daily care")) return firstAvailable("VetTech");
        if (task.equals("Adoption processing")) return firstAvailable("AdoptionCounselor");
        return null;
    }

    private Staff firstAvailable(String role) {
        for (Staff s : staff) {
            if (s.getRole().equals(role) && s.canTakeTask()) return s;
        }
        return null;
    }
}