package com.fredericboisguerin.insa;

import org.junit.Test;

public class PackageTestShould {

    private int     VALID_HEIGHT    = 229;
    private int     VALID_WIDTH     = 162;
    private int     VALID_DEPTH     = 25;
    private double  VALID_WEIGHT    = 1.8;

    private CountryDestination VN;

    @Test (expected = InvalidDestinationException.class)
    public void fail_if_destination_is_not_valid()
        throws InvalidDestinationException{

        Package p = new LargePackage(VALID_HEIGHT, VALID_WIDTH, VALID_DEPTH, VALID_WEIGHT);
        System.out.println(ShippingCostsCalculator.calculateShippingCost(p,VN));
    }

}
