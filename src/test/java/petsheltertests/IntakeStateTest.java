package petsheltertests;

import org.junit.jupiter.api.Test;
import petshelter.animals.Animal;
import petshelter.states.IntakeState;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class IntakeStateTest {

    @Test
    void intakeState_returnsCorrectStatusName() {
        IntakeState state = new IntakeState();

        assertEquals("INTAKE", state.getStatusName());
    }

    @Test
    void animalDefaultState_isIntake() {
        Animal animal = new Animal();

        assertEquals("INTAKE", animal.getStatusName());
    }
}