package petshelter.people;

/**
 * Base class for shelter staff.
 */
public class Staff implements ISMem {

    protected String memberId;
    protected String name;
    protected String role;
    //this shows how many tasks a given role can handle in a day.
    protected int capacity;
    protected int assignedTasks;

    public Staff(String memberId, String name, String role, int capacity) {
        if (memberId == null || memberId.isBlank()) {
            throw new IllegalArgumentException("Member ID cannot be blank");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
        //shouldnt be 0 or less.
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity cannot be negative");
        }

        this.memberId = memberId;
        this.name = name;
        this.role = role;
        this.capacity = capacity;
        this.assignedTasks = 0;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getAssignedTasks() {
        return assignedTasks;
    }

    public boolean canTakeTask() {
        return assignedTasks < capacity;
    }

    public void assignTask() {
        if (!canTakeTask()) {
            throw new IllegalStateException("Staff capacity reached");
        }
        assignedTasks++;
    }

    /**
     *
     * Using MemberID instead of SHA-256 for simplicity per README.md
     * definitely in over my head to set up SHA-256 also learned that it's for other things
     */
    @Override
    public String getCredentialHash() {
        return memberId;
    }
}