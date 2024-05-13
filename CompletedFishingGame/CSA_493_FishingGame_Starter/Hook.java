/**
 * Activity 4.9.3
 */
public class Hook extends LakeObject {
    private int strength;

    // Constructor to initialize the strength variable
    public Hook() {
        super(); // Invokes the superclass constructor
        strength = 55;
        setCost(15); // Set the cost to 15
    }

    // Accessor method for strength
    public int getStrength() {
        return strength;
    }
}

