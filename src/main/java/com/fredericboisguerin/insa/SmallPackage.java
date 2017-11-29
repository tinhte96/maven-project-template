package com.fredericboisguerin.insa;

public class SmallPackage extends Package {

    public SmallPackage(int height, int width, int depth, double weight) {
        super(height,width,depth,weight);
    }

    public double calculateLocalShippingCost() {
        return 12.00;
    }

    public String toString() {
        return "this is a small package with cost " + this.roundedCost();
    }
}
