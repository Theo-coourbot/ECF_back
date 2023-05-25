package org.example.ihm;

import org.example.entities.Activity;
import org.example.entities.Center;
import org.example.services.ActivityService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class IhmActivity {
    static ActivityService activityService = new ActivityService();
    static Scanner scanner = new Scanner(System.in);


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
                case ("5"):
                    addActivityToCenter();
                    break;
                case ("0"):
                    IHM.start();
                    break;
                default:
                    System.out.println("1,2,3,4 ou 0 s'il vous plait  ");
                    break;

            }



        } while (!choice.equals("0"));
        activityService.end();
    }

    // method suplementaire
    public static  void addActivityToCenter(){
        System.out.println("id de l'activite a enrgistre");
        seeAllActivity();
        int id;
        id = scanner.nextInt();
        scanner.nextLine();
        Activity activity = activityService.findById(id);
        System.out.println("dans quelle centre se deroulera l'activite");
        IhmCenter.seeAllCenter();
        id = scanner.nextInt();
        scanner.nextLine();
        Center center = IhmCenter.centerService.findById(id);
        activity.setCenteractivity(center);
        activityService.joinActivityToCenter(activity);

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
        System.out.println("nouveau nom de l'activite");
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
            System.out.println("aucune activité présente");
        } else {
            System.out.println("liste des activités");
            for (Activity a : activities){
                System.out.println(a.getIdCours()+ " // nom du cours : "+ a.getName() + "// date " + a.getDateSession());
                System.out.println(a.getCenteractivity() != null ?  " se deroulera a la salle " + a.getCenteractivity().getName()  :  " pas de salle lie");
            }

        }
    }
    public static void addActivity(){
        Activity activity = new Activity();
        System.out.println("ajout de l'activité");
        System.out.println("nom de l'activité");
        String nameActivity = scanner.nextLine();
        System.out.println("date du centre");
        System.out.println("date de l'activite format dd/MM/yyyy");
        String dateStr = scanner.nextLine();
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateStr);
            activity.setDateSession(date);


        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        activity.setName(nameActivity);
        activityService.create(activity);

    }

    public static void displayInfoActivity(){
        System.out.println("=====gestion d'activités =====");
        System.out.println("1. crée une activité");
        System.out.println("2. voir les activités");
        System.out.println("3. modifier une activité");
        System.out.println("4. supprimer une activité");
        System.out.println("5. lié l'activite a un centre");
        System.out.println("0. retour");

    }

}
