package com.fredericboisguerin.insa;

import java.util.Scanner;

public class UserInterface {


        Scanner sc;

        public UserInterface() {
            sc = new Scanner(System.in);
        }

        public Package askPackageInfo() {

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

            return PackageFactory.measurePackage(height,width,depth,weight);
        }

        public CountryDestination askDestination()
                throws InvalidDestinationException{

            System.out.println("Your destination : ");
            System.out.print("destination : ");
            String aux = sc.nextLine();
            System.out.println();

            for (CountryDestination cd : CountryDestination.values()){
                if (cd == (CountryDestination.valueOf(aux))){
                    return cd;
                }
            }
            throw  new InvalidDestinationException();
        }
}
