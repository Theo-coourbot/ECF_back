package org.example.ihm;

import org.example.entities.Activity;
import org.example.entities.Center;
import org.example.services.ActivityService;
import org.example.services.CenterService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class IHM {
     static Scanner scanner = new Scanner(System.in);
     static CenterService centerService = new CenterService();
     static ActivityService activityService = new ActivityService();


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
                    addActivity();
                    break;
                case ("2"):
                    seeAllActivity();
                    break;
                case ("3"):
                    updateActivity();
                    break;
                case ("4"):
                    deleteActivity();
                    break;
                case ("0"):
                    start();
                    break;
                default:
                    System.out.println("1,2,3,4 ou 0 s'il vous plait  ");
                    break;

            }



        } while (!choice.equals("0"));
        activityService.end();
    }


    //crud activite
    public static void  deleteActivity(){
        System.out.println("id de l'activite a supprimer");
        seeAllActivity();
        int id;
        id = scanner.nextInt();
        scanner.nextLine();
        Activity activity = activityService.findById(id);
        activityService.delete(activity);
    }

    public static void  updateActivity(){
        System.out.println("id de l'activite a modifier");
        String choice;
        seeAllActivity();
        int id;
        id = scanner.nextInt();
        scanner.nextLine();
        Activity activity = activityService.findById(id);
        System.out.println("nouveau nom du centre");
        String nameActivity = scanner.nextLine();
        System.out.println("modifier la date 1 : oui autre non");
        choice = scanner.nextLine();
        if (choice.equals("1")){
            System.out.println("date de l'activite format dd/MM/yyyy");
            String dateStr = scanner.nextLine();
            try {
                Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateStr);
                activity.setDateSession(date);

            }catch (Exception e){
                System.out.println(e.getMessage());
            }

        }
        activity.setName(nameActivity);
        activityService.update(activity);
        System.out.println("activite actualise");


    }
    public static void  seeAllActivity(){
        List<Activity> activities = null;
        activities = activityService.findAll();
        if (activities == null){
            System.out.println("aucun centre présent");
        } else {
            System.out.println("liste des centres");
            for (Activity a : activities){
                System.out.println(a.getIdCours()+ " // nom du cours : "+ a.getName() + "// date " + a.getDateSession());
            }

        }
    }
    public static void addActivity(){
        System.out.println("ajout de centre");
        System.out.println("nom du centre");
        String nameCenter = scanner.nextLine();
        System.out.println("adresse du centre");
        String adressCenter = scanner.nextLine();
        Center center = new Center();
        center.setName(nameCenter);
        center.setAdress(adressCenter);
        centerService.create(center);

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
                    seeAllCenter();
                    break;
                case ("3"):
                    updateCenter();
                    break;
                case ("4"):
                    deleteCenter();
                    break;
                case ("0"):
                    start();
                    break;
                default:
                    System.out.println("1,2,3,4 ou 0 s'il vous plait  ");
                    break;

            }



        } while (!choice.equals("0"));
        centerService.end();

    }


    // crud centre
    public static void  deleteCenter(){
        System.out.println("id du centre a retiré");
        seeAllCenter();
        int id;
        id = scanner.nextInt();
        scanner.nextLine();
        Center center = centerService.findById(id);
        centerService.delete(center);
    }

    public static void  updateCenter(){
        System.out.println("id du centre a modifier");
        String choice;
        seeAllCenter();
        int id;
        id = scanner.nextInt();
        scanner.nextLine();
        Center center = centerService.findById(id);
        System.out.println("nouveau nom du centre");
        String nameCenter = scanner.nextLine();
        System.out.println("modifier l'adresse 1 : oui autre non");
        choice = scanner.nextLine();
        if (choice.equals("1")){
        System.out.println("adresse du centre");
        String adressCenter = scanner.nextLine();
        center.setAdress(adressCenter);
        }
        center.setName(nameCenter);
        centerService.update(center);
        System.out.println("centre actualise");


    }
    public static void  seeAllCenter(){
        List<Center> centerList = null;
        centerList = centerService.findAll();
        if (centerList == null){
            System.out.println("aucun centre présent");
        } else {
            System.out.println("liste des centres");
            for (Center c : centerList){
                System.out.println(c.getId()+ " // nom du centre : "+ c.getName() + "// adresse " + c.getAdress());
            }

        }
    }
    public static void addCenter(){
        System.out.println("ajout de centre");
        System.out.println("nom du centre");
        String nameCenter = scanner.nextLine();
        System.out.println("adresse du centre");
        String adressCenter = scanner.nextLine();
        Center center = new Center();
        center.setName(nameCenter);
        center.setAdress(adressCenter);
        centerService.create(center);

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
