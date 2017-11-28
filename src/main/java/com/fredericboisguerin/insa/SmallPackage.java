package com.fredericboisguerin.insa;

public class SmallPackage extends Package {

    public SmallPackage (int height, int width, int depth, double weight){
        this.height = height;
        this.width = width;
        this.depth = depth;
        this.weight = weight;
    }

    public double calculateLocalShippingCost() {
        return 12.00;
    }
}
