package org.example.ihm;


import java.util.Scanner;

public class IHM {
     static Scanner scanner = new Scanner(System.in);



    public static void start(){
        String choice;
        do {
            displayMenuGeneral();
            choice = scanner.nextLine();
            System.out.println("ok");
            switch (choice){
                case ("1") :
                    IhmAdhering.displayMenuAdhering(scanner);
                    break;
                case ("2") :
                    IhmActivity.displayMenuActivity(scanner);
                    break;

                case ("3") :
                    IhmCenter.displayMenuCenter(scanner);
                    break;
                case ("0") :
                    System.out.println("bye");
                    break;



                default :
                    System.out.println("1,2,3 ou 0 s'il vous plait");


            }

        } while (!choice.equals("0"));



    }



    public static void displayMenuGeneral(){



        System.out.println("gestion de fitnessShark");
        System.out.println("1.gestion des adherants");
        System.out.println("2.gestion des activités");
        System.out.println("3.gestion des centres");
        System.out.println("0.quiter");
    }

}
