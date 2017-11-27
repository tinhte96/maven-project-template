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


    public static boolean checkSmallPackage(int height, int width, int depth) {

        ArrayList<Integer> array = new ArrayList<>();
        array.add(height);
        array.add(width);
        array.add(depth);
        Collections.sort(array);

        return     array.get(2) <= STANDARD_HEIGHT
                && array.get(0) <= STANDARD_DEPTH
                && array.get(1) <= STANDARD_WIDTH ;
    }

    public static boolean checkMediumPackage(double weight) {
        return weight <= STANDARD_WEIGHT;
    }

    public abstract double calculateLocalShippingCost();

    public String toString(){
        double volume = this.height * this.width * this.depth * Math.pow(10,-6);
        return "height : "+this.height+"\nwidth "+this.width+"\ndepth "+this.depth+"\nweight "+this.weight
                +"\ncost "+this.calculateLocalShippingCost()
                +"\nvolume"+(volume)
                +"\ncostSize"+(volume*1.43)
                +"\ncostWeight"+(this.weight*21.36);
    }

    protected static double round(double value) {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(3, RoundingMode.CEILING);
        return bd.doubleValue();
    }
}
