package com.fredericboisguerin.insa;

public class MediumPackage extends Package {

    public MediumPackage (int height, int width, int depth, double weight){
        super(height,width,depth,weight);
    }

    public double calculateLocalShippingCost() {
        return this.weight * 17.59 + 2.86;
    }

    public String toString() {
        return "this is a medium package with cost " + this.roundedCost();
    }
}
