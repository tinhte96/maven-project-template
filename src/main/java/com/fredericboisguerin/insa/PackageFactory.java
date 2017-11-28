package com.fredericboisguerin.insa;

import java.util.ArrayList;
import java.util.Collections;

public class PackageFactory {

    public static Package measurePackage (int height, int width, int depth, double weight) {
        if (checkSmallPackage(height,width,depth)){
            return new SmallPackage(height, width, depth, weight);
        }
        else if (checkMediumPackage(weight)){
            return new MediumPackage(height, width, depth, weight);
        }
        else {
            return new LargePackage(height, width, depth, weight);
        }
    }

    public static boolean checkMediumPackage(double weight) {
        return weight <= Package.STANDARD_WEIGHT;
    }

    public static boolean checkSmallPackage(int height, int width, int depth) {

        ArrayList<Integer> array = new ArrayList<>();
        array.add(height);
        array.add(width);
        array.add(depth);
        Collections.sort(array);

        return     array.get(2) <= Package.STANDARD_HEIGHT
                && array.get(0) <= Package.STANDARD_DEPTH
                && array.get(1) <= Package.STANDARD_WIDTH ;
    }
}
