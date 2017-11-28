package com.fredericboisguerin.insa;

public class PackageFactory {

    public static Package measurePackage (int height, int width, int depth, double weight) {
        if (Package.checkSmallPackage(height,width,depth)){
            return new SmallPackage(height, width, depth, weight);
        }
        else if (Package.checkMediumPackage(weight)){
            return new MediumPackage(height, width, depth, weight);
        }
        else {
            return new LargePackage(height, width, depth, weight);
        }
    }
}
