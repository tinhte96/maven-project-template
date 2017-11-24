package com.fredericboisguerin.insa;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static jdk.nashorn.internal.objects.NativeMath.round;

public class Package {

    private final int STANDARD_HEIGHT = 229;
    private final int STANDARD_WIDTH = 162;
    private final int STANDARD_DEPTH = 25;
    private final double STANDARD_WEIGHT = 1.8;

    private int height;
    private int width;
    private int depth;
    private double weight;

    public Package (int height, int width, int depth, double weight){
        this.height = height;
        this.width = width;
        this.depth = depth;
        this.weight = weight;
    }

    private boolean checkSize() {
        return this.height <= STANDARD_HEIGHT &&
                this.width <= STANDARD_WIDTH  &&
                this.depth <= STANDARD_DEPTH ;
    }

    private boolean checkWeight() {
        return this.weight <= STANDARD_WEIGHT;
    }

    private static double round(double value) {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(2, RoundingMode.CEILING);
        return bd.doubleValue();
    }

    public double calculateLocalShippingCost(){
        double costSize = 0;
        double costWeight = 0;
        double volume = 0;

        if (checkSize()) {
            return round(12.00);
        }

        if (checkWeight()){
            return round(this.weight * 17.59 + 2.86);
        }

        volume = this.height * this.width * this.depth * Math.pow(10,-6);
        costSize = volume * 1.43;
        costWeight = this.weight * 21.62;

        if(costSize <= costWeight){
            return round(costSize);
        }
        else {
            return round(costWeight);
        }
    }
}
