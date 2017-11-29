package com.fredericboisguerin.insa;

import java.util.Scanner;

public class UserInterface {


        Scanner sc;

        public UserInterface() {
            sc = new Scanner(System.in);
        }

        public Package askPackageInfo(PackageFactory pf) {

            System.out.println("Your package information : ");

            System.out.print("height : ");
            Integer height = sc.nextInt();
            System.out.println();

            System.out.print("width : ");
            Integer width = sc.nextInt();
            System.out.println();

            System.out.print("depth : ");
            Integer depth = sc.nextInt();
            System.out.println();

            System.out.print("weight : ");
            Double weight = sc.nextDouble();
            System.out.println();

            return pf.measurePackage(height,width,depth,weight);
        }

        public CountryDestination askDestination(){

            System.out.print("destination : ");
            String aux = sc.next();
            System.out.println();

            return CountryDestination.valueOf(aux);
        }
}
