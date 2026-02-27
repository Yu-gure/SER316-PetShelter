import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;
import petshelter.animals.Animal;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    @DisplayName("T-Q1-basicBuildTest")
    void tQ1BasicBuildTest() {
        assertTrue(true);
    }


    @Test
    void T_Q1_basicBuildTest() {
        assertTrue(true);
    }

    @Test
    void T_Q2_animalDefaultStateIsIntake() {
        Animal animal = new Animal("A100", "Dog", 2, "Healthy", "SZ-001");
        assertEquals("INTAKE", animal.getStatusName());
    }

}
