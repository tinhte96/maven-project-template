package com.fredericboisguerin.insa;

import javax.print.attribute.standard.Destination;

enum DestinationCountry {
    FR,MC
}
public class ShippingCostsCalculator {

    public double calculateShippingCost(Package p, DestinationCountry d) {

        double standardCost = p.calculateLocalShippingCost();
        if (d.equals(DestinationCountry.FR)){
            return standardCost;
        }
        else if (d.equals(DestinationCountry.MC)){
            return (standardCost * 1.087);
        }
        return 0;
    }
}
