package uk.ac.gla.csc1109;  // Replace this package with your actual package structure

public class KnifeInPackage {

    private String type;
    private int sharpness;

    // Constructor
    public KnifeInPackage() {
        this.type = "Chef's Knife In Package";
        this.sharpness = 10;
    }

    // Getter for type
    public String getType() {
        return type;
    }

    // Getter for sharpness
    public int getSharpness() {
        return sharpness;
    }

    // Method to cut
    public String cut(String vegetable) {
        if (sharpness > 5) {
            return "Successfully cut " + vegetable + " with ease!";
        } else {
            return "Knife is not sharp enough to cut " + vegetable + ". Please sharpen it.";
        }
    }
}
