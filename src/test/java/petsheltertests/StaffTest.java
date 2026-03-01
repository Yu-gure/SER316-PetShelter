package petsheltertests;

import org.junit.jupiter.api.Test;
import petshelter.people.Staff;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class StaffTest {

    @Test
    void staffConstructor_setsFieldsCorrectly() {
        Staff staff = new Staff("M001", "Alex", "VetTech", 2);

        assertEquals("M001", staff.getMemberId());
        assertEquals("Alex", staff.getName());
        assertEquals("VetTech", staff.getRole());
        assertEquals(2, staff.getCapacity());
        assertEquals(0, staff.getAssignedTasks());
        assertTrue(staff.canTakeTask());
    }
    @Test
    void assignTask_incrementsAssignedTasksUntilCapacityReached() {
        Staff staff = new Staff("M002", "JimmyMcGill", "Veterinarian", 1);

        assertTrue(staff.canTakeTask());
        staff.assignTask();

        assertEquals(1, staff.getAssignedTasks());
        assertFalse(staff.canTakeTask());
    }
    @Test
    void getCredentialHash_returnsMemberId() {
        Staff staff = new Staff("M004", "Chuck McGill", "VetTech", 3);
        assertEquals("M004", staff.getCredentialHash());
    }

}