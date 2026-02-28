package petsheltertests;

import org.junit.jupiter.api.Test;
import petshelter.animals.Animal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalStateTest {

    @Test
    void T_Q1_animalStateTransitionsWork() {
        Animal a = new Animal("D007", "Dog", 2, "Healthy", "SZ-101");

        assertEquals("INTAKE", a.getStatusName());

        a.handleState();
        assertEquals("AVAILABLE", a.getStatusName());

        a.handleState();
        assertEquals("PENDING_ADOPTION", a.getStatusName());

        a.handleState();
        assertEquals("ADOPTED", a.getStatusName());
    }
}