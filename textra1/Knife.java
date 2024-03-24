//package com.example.tools;  // Replace this package with your actual package structure

public class Knife {

    private String type;
    private int sharpness;

    // Constructor
    public Knife() {
        this.type = "Chef's Knife";
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
