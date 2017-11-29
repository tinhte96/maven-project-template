package com.fredericboisguerin.insa;

import java.util.Scanner;

public class App {

    public static void main (String[] args)
            throws InvalidDestinationException, IllegalArgumentException{

        final Scanner sc = new Scanner(System.in);
        PackageFactory pf = new PackageFactory();
        UserInterface ui = new UserInterface();

        boolean continuation = true;
        int choose = 2;
        while (continuation) {
            displayMenu();

            try {
                choose = sc.nextInt();
            }
            catch(Exception e){
                System.out.println("please choose 0 or 1");
            }

            switch (choose){
                case 0 :
                    continuation = false;
                    break;
                case 1 :

                    try {
                        Package p = ui.askPackageInfo(pf);
                        System.out.println(p.toString());

                        try{
                            CountryDestination cd = ui.askDestination();
                            Double cost = ShippingCostsCalculator.calculateShippingCost(p,cd);
                            System.out.println("your cost is "+ String.format( "%.2f", cost).replace('.',','));
                        }
                        catch (Exception e){
                            e.printStackTrace();
                        }

                    }
                    catch(Exception e){
                        System.out.printf("Erreur");
                    }

                    break;
            }
        }
    }

    public static void displayMenu(){
        System.out.println () ;
        System.out.println ("MENU") ;
        System.out.println () ;
        System.out.println ("0 - Exit") ;
        System.out.println ("1 - Calcul cost") ;
        System.out.println () ;
    }

}
