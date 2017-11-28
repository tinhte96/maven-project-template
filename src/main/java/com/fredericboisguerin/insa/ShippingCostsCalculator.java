package com.fredericboisguerin.insa;

public class ShippingCostsCalculator {

    public static double calculateShippingCost(Package p, CountryDestination d) throws InvalidDestinationException {

        double standardCost = p.calculateLocalShippingCost();

        if (d == CountryDestination.FR){
            return standardCost;
        }
        else if (d == CountryDestination.MC){
            return (standardCost * 1.087);
        }
        else if (d == CountryDestination.DOMTOM){
            return (standardCost * 1.054 + 1.26);
        }
        else {
            throw new InvalidDestinationException();
        }
    }
}
