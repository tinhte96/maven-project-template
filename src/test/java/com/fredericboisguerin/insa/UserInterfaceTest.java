package com.fredericboisguerin.insa;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class UserInterfaceTest {

    private ByteArrayOutputStream out;

    @Before
    public void setUp() {
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @Test
    public void call_measure_package(){

        System.setIn(new ByteArrayInputStream("19\n12\n18\n2.354\n".getBytes()));

        PackageFactory pf = Mockito.mock(PackageFactory.class);
        UserInterface ui = new UserInterface();
        ui.askPackageInfo(pf);

        int height = 19;
        int width = 12;
        int depth = 18;
        double weight = 2.354;

        Mockito.verify(pf).measurePackage(height,width,depth,weight);
    }

    @Test
    public void destination () throws InvalidDestinationException {

        System.setIn(new ByteArrayInputStream("DOMTOM".getBytes()));
        UserInterface ui = new UserInterface();

        CountryDestination cd = ui.askDestination();
        System.out.printf(cd.toString());

        assertThat(standardOutput(), containsString(CountryDestination.DOMTOM.toString()));

    }

    private String standardOutput() {
        return out.toString();
    }

}
