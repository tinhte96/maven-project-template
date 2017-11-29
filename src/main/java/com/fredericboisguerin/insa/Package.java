package com.fredericboisguerin.insa;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;


public abstract class Package {

    public static final int STANDARD_HEIGHT = 229;
    public static final int STANDARD_WIDTH = 162;
    public static final int STANDARD_DEPTH = 25;
    public static final double STANDARD_WEIGHT = 1.8;

    protected int height;
    protected int width;
    protected int depth;
    protected double weight;

    public Package (int height, int width, int depth, double weight){
        this.height = height;
        this.width = width;
        this.depth = depth;
        this.weight = weight;
    }


    public abstract double calculateLocalShippingCost();

    public double roundedCost () {
        return round(this.calculateLocalShippingCost());
    }

    public static double round(double value) {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public abstract String toString();
}
