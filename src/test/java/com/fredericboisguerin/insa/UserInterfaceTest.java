package com.fredericboisguerin.insa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;

public class UserInterfaceTest {

    @Test
    public void type_small_package_dimension_return_new_small_package(){

        System.setIn(new ByteArrayInputStream("191\n123\n18\n2.354d\n".getBytes()));

        PackageFactory pf = Mockito.mock(PackageFactory.class);
        UserInterface ui = new UserInterface();
        ui.askPackageInfo();

        int height = 191;
        int width = 123;
        int depth = 18;
        double weight = 2.354d;

        Mockito.verify(pf).measurePackage(height,width,depth,weight);
    }
}
