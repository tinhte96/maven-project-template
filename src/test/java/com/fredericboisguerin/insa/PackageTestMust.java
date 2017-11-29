package com.fredericboisguerin.insa;


import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;


/**
 * Unit test for Package.
 */
@RunWith(Parameterized.class)
public class PackageTestMust {

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{

                { 191, 123, 18,  2.354d, "FR", "12,00" },

                { 253, 215, 164, 1.565d, "FR", "30,39" },

                { 653, 133, 271, 2.132d, "FR", "46,09" },

                { 653, 331, 271, 3.650d, "FR", "83,76" },

                { 123, 191, 18,  2.354d, "MC", "13,04" },

                { 253, 215, 164, 1.565d, "MC", "33,03" },

                { 653, 133, 271, 2.132d, "MC", "50,10" },

                { 653, 331, 271, 3.650d, "MC", "91,05" },

                { 191, 123, 18,  2.354d, "DOMTOM", "13,91" },

                { 253, 215, 164, 1.565d, "DOMTOM", "33,29" },

                { 653, 133, 271, 2.132d, "DOMTOM", "49,84" },

                { 653, 331, 271, 3.650d, "DOMTOM", "89,54" },});
    }

    private double fInput;
    private String fExpected;

    public PackageTestMust(int height, int width, int depth, double weight, String destination, String expected)
            throws InvalidDestinationException {

        CountryDestination cd = CountryDestination.valueOf(destination);
        PackageFactory pf = new PackageFactory();

        Package p = pf.measurePackage(height,width,depth,weight);
        this.fInput = ShippingCostsCalculator.calculateShippingCost(p,cd);
        this.fExpected = expected;
    }

    @Test
    public void test() {
        String result = String.format( "%.2f", fInput).replace('.',',');
        assertEquals(fExpected,result);
    }
}
