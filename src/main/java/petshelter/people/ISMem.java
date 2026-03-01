package petshelter.people;

/**
 * Interface for shelter members.
 */
public interface ISMem {

    /**
     * Returns the credential identifier for the member.
     * (Using MemberID as credential for simplicity.)
     */
    String getCredentialHash();
}