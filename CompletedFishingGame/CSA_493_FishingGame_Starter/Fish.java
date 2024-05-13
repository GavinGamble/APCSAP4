public class Fish extends LakeObject {
    // Override the getCost method to return the product of weight and cost
    @Override
    public int getCost() {
        // Using superclass accessors to avoid recursion
        return super.getWeight() * super.getCost();
    }
}
