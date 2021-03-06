package com.fredericboisguerin.insa;

public class LargePackage extends Package {

    public LargePackage (int height, int width, int depth, double weight){
        super(height,width,depth,weight);
    }

    public double calculateLocalShippingCost() {
        double volume = this.height * this.width * this.depth * Math.pow(10,-6);
        double costSize = volume * 1.43;
        double costWeight = this.weight * 21.62;
        return Math.max(costSize,costWeight);
    }

    public String toString() {
        return "this is a large package with cost " + this.roundedCost();
    }
}
