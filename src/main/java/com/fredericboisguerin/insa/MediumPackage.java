package com.fredericboisguerin.insa;

public class MediumPackage extends Package {

    private int height;
    private int width;
    private int depth;
    private double weight;

    public MediumPackage (int height, int width, int depth, double weight){
        this.height = height;
        this.width = width;
        this.depth = depth;
        this.weight = weight;
    }

    public double calculateLocalShippingCost() {
        return round(this.weight * 17.59 + 2.86);
    }
}
