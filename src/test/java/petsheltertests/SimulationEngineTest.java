package petsheltertests;

import org.junit.jupiter.api.Test;
import petshelter.Shelter;
import petshelter.SimulationEngine;

import static org.junit.jupiter.api.Assertions.*;

public class SimulationEngineTest {

    @Test
    void T_Q3_romanNumeralConversionWorks() {
        SimulationEngine engine = new SimulationEngine(new Shelter());
        assertEquals("I", engine.toRoman(1));
        assertEquals("VII", engine.toRoman(7));
    }
}