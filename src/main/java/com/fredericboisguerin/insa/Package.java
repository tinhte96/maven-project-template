package com.fredericboisguerin.insa;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;


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

        ArrayList<Integer> array = new ArrayList<>();
        array.add(this.height);
        array.add(this.width);
        array.add(this.depth);
        Collections.sort(array);

        return     array.get(2) <= this.STANDARD_HEIGHT
                && array.get(0) <= this.STANDARD_DEPTH
                && array.get(1) <= this.STANDARD_WIDTH ;
    }

    private boolean checkWeight() {
        return this.weight <= STANDARD_WEIGHT;
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

        if(costSize >= costWeight){
            return round(costSize);
        }
        else {
            return round(costWeight);
        }
    }

    public String toString(){
        double volume = this.height * this.width * this.depth * Math.pow(10,-6);
        return "height : "+this.height+"\nwidth "+this.width+"\ndepth "+this.depth+"\nweight "+this.weight
                +"\ncost "+this.calculateLocalShippingCost()
                +"\nvolume"+(volume)
                +"\ncostSize"+(volume*1.43)
                +"\ncostWeight"+(this.weight*21.36);
    }

    private static double round(double value) {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(3, RoundingMode.CEILING);
        return bd.doubleValue();
    }
}
