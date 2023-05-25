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
                    displayMenuAdhering(scanner);
                    break;
                case ("2") :
                    displayMenuActivity(scanner);
                    break;

                case ("3") :
                    displayMenuCenter(scanner);
                    break;
                case ("0") :
                    System.out.println("bye");
                    break;



                default :
                    System.out.println("1,2,3 ou 0 s'il vous plait");


            }

        } while (!choice.equals("0"));


    }

    // gestion d'adherants
    public static void displayMenuAdhering(Scanner s){
        String choice;
        do {
            displayInfoAdhering();
            choice = s.nextLine();
            switch (choice){
                case ("1"):
                    break;
                case ("2"):
                    break;
                case ("3"):
                    break;
                case ("4"):
                    break;
                case ("0"):
                    start();
                    break;

                default:
                    System.out.println("1,2,3,4 ou 0 s'il vous plait  ");
                    break;

            }



        } while (!choice.equals("0"));
    }

    // ==========================================
    // gestion des activités
    public static void displayMenuActivity(Scanner s){
        String choice;
        do {
            displayInfoActivity();
            choice = s.nextLine();
            switch (choice){
                case ("1"):
                    break;
                case ("2"):
                    break;
                case ("3"):
                    break;
                case ("4"):
                    break;
                case ("0"):
                    start();
                    break;
                default:
                    System.out.println("1,2,3,4 ou 0 s'il vous plait  ");
                    break;

            }



        } while (!choice.equals("0"));
    }


    // ============================================
    // gestion des centres

    public static void displayMenuCenter(Scanner s){
        String choice;
        do {
            displayInfoCenter();
            choice = s.nextLine();
            switch (choice){
                case ("1"):
                    addCenter();
                    break;
                case ("2"):
                    break;
                case ("3"):
                    break;
                case ("4"):
                    break;
                case ("0"):
                    start();
                    break;
                default:
                    System.out.println("1,2,3,4 ou 0 s'il vous plait  ");
                    break;

            }



        } while (!choice.equals("0"));

    }


    // crud centre
    public static void addCenter(){
        System.out.println("ajout de centre");

    }



    // ==============================================
    // affichage de menus

    public static void displayMenuGeneral(){
        System.out.println("gestion de fitnessShark");
        System.out.println("1.gestion des adherants");
        System.out.println("2.gestion des activités");
        System.out.println("3.gestion des centres");
        System.out.println("0.quiter");
    }
    public static void displayInfoAdhering(){
        System.out.println("=====gestion d'adherant =====");
        System.out.println("1. inscrption d'adherant");
        System.out.println("2. voir les adherants");
        System.out.println("3. modifier un adherant");
        System.out.println("4. supprimer un adherant");
        System.out.println("0. retour");

    }public static void displayInfoActivity(){
        System.out.println("=====gestion d'activités =====");
        System.out.println("1. crée une activité");
        System.out.println("2. voir les activités");
        System.out.println("3. modifier une activité");
        System.out.println("4. supprimer une activité");
        System.out.println("0. retour");

    }
    public static void displayInfoCenter(){
        System.out.println("=====gestion des centre =====");
        System.out.println("1. enregistrer un nouveau centre");
        System.out.println("2. voir les centres");
        System.out.println("3. modifier un centre");
        System.out.println("4. supprimer un centre");
        System.out.println("0. retour");

    }
}
