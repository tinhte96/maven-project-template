package com.fredericboisguerin.insa;

public class ShippingCostsCalculator {

    public static double calculateShippingCost(Package p, CountryDestination d) throws InvalidDestinationException {

        double standardCost = p.calculateLocalShippingCost();
        System.out.println(standardCost);
        if (d == CountryDestination.FR){
            return standardCost;
        }
        else if (d == CountryDestination.MC){
            return (standardCost * 1.087);
        }
        else {
            throw new InvalidDestinationException();
        }
    }
}
