package petsheltertests;

import org.junit.jupiter.api.Test;
import petshelter.animals.Animal;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AnimalTest {

    @Test
    void animalConstructor_setsFieldsCorrectly() {
        Animal animal = new Animal("K9", "Dog", 3, "Healthy", "SZ-001");

        assertEquals("K9", animal.getId());
        assertEquals("Dog", animal.getSpecies());
        assertEquals(3, animal.getAge());
    }

    @Test
    void setAge_negativeAge_throwsException() {
        Animal animal = new Animal();

        assertThrows(IllegalArgumentException.class, () -> {
            animal.setAge(-1);
        });
    }
}