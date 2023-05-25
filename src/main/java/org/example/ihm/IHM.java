package org.example.ihm;

import org.example.entities.Activity;
import org.example.entities.Adhering;
import org.example.entities.Center;
import org.example.services.ActivityService;
import org.example.services.AdheringService;
import org.example.services.CenterService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class IHM {
     static Scanner scanner = new Scanner(System.in);
     static CenterService centerService = new CenterService();
     static AdheringService adheringService = new AdheringService();
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
                    addAdhering();
                    break;
                case ("2"):
                    seeAllAdhering();
                    break;
                case ("3"):
                    updateAdhering();
                    break;
                case ("4"):
                    deleteAdhering();
                    break;

                case ("5"):
                    registerAdheringForActivity();
                    break;

                case ("6"):
                    registerAdheringCenter();
                    break;
                case ("0"):
                    start();
                    break;

                default:
                    System.out.println("1,2,3,4 ou 0 s'il vous plait  ");
                    break;

            }



        } while (!choice.equals("0"));
        adheringService.end();

    }
//    adherent methode

public static  void  registerAdheringCenter(){
    System.out.println("id de l'adherent a enrgistre");
    seeAllAdhering();
    int id;
    id = scanner.nextInt();
    scanner.nextLine();
    Adhering adhering = adheringService.findById(id);
    System.out.println("a quelle salle voulez vous vous incrire");
    seeAllCenter();
    id = scanner.nextInt();
    scanner.nextLine();
    Center center = centerService.findById(id);
    adhering.setCenter(center);
    adheringService.joinAdheringToCenter(adhering);

}

public  static  void  registerAdheringForActivity(){
    System.out.println("id de l'adherent a enrgistre");
    seeAllAdhering();
    int id;
    id = scanner.nextInt();
    scanner.nextLine();
    Adhering adhering = adheringService.findById(id);
    System.out.println("id de l'activite");
    seeAllActivity();
    id = scanner.nextInt();
    scanner.nextLine();
    Activity activity = activityService.findById(id);
    adhering.addActivity(activity);
    adheringService.addAdheringActivity(adhering);
    System.out.println("inscription a l'activité oki");

}
//    crud adherent

public static void  deleteAdhering(){
    System.out.println("id de l'adherent a supprimer");
    seeAllAdhering();
    int id;
    id = scanner.nextInt();
    scanner.nextLine();
    Adhering adhering = adheringService.findById(id);
    adheringService.delete(adhering);

}

    public static void  updateAdhering(){
        System.out.println("id de l'adherent a modifier");

        seeAllAdhering();
        int id;
        id = scanner.nextInt();
        scanner.nextLine();
        Adhering adhering = adheringService.findById(id);
        System.out.println("nouveau prenom de l'adherent");
        String firsNameAdhering = scanner.nextLine();
        System.out.println("nouveau nom de l'adherent");
        String lastNameAdhering = scanner.nextLine();
        System.out.println("nouvelle age de l'adherent");
        int ageAdhering = scanner.nextInt();
        scanner.nextLine();

        adhering.setFirstName(firsNameAdhering);
        adhering.setLastName(lastNameAdhering);
        adhering.setAge(ageAdhering);
        adheringService.update(adhering);
        System.out.println("adherent actualise");


    }
    public static void  seeAllAdhering(){
        List<Adhering> adherings = null;
        int i = 1;
        adherings = adheringService.findAll();
        if (adherings == null){
            System.out.println("aucun adherent présent");
        } else {
            System.out.println("liste des adherents");
            for (Adhering a : adherings){
                System.out.println( a.getId()+" || " + a.getLastName()+ " || "+ a.getFirstName() + " || age :  " + a.getAge() );
                System.out.println(a.getCenter() != null ?"nom du centre : " + a.getCenter().getName() : " pas de centre atitré ");
                if (a.getActivities().size() > 0){
                    for (Activity activity : a.getActivities() ){

                        System.out.println(" activite" + i +" : " + activity.getName() +" date de l'activite : " +activity.getDateSession());
                        i++;
                    }
                    i=1;
                }
            }

        }
    }
    public static void addAdhering(){
        Adhering adhering = new Adhering();
        System.out.println("ajout de l'adherent");
        System.out.println("nom de l'adherent");
        String nameAdhering = scanner.nextLine();
        System.out.println("prenom de l'adherent");
        String firstNameAdhering = scanner.nextLine();
        System.out.println("age de l'adherent");
        int ageAdhering = scanner.nextInt();
        scanner.nextLine();
       adhering.setLastName(nameAdhering);
       adhering.setFirstName(firstNameAdhering);
        adhering.setAge(ageAdhering);
        adheringService.create(adhering);

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
                case ("5"):
                    addActivityToCenter();
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

    // method suplementaire
    public static  void addActivityToCenter(){
        System.out.println("id de l'activite a enrgistre");
        seeAllActivity();
        int id;
        id = scanner.nextInt();
        scanner.nextLine();
        Activity activity = activityService.findById(id);
        System.out.println("dans quelle centre se deroulera l'activite");
        seeAllCenter();
        id = scanner.nextInt();
        scanner.nextLine();
        Center center = centerService.findById(id);
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
        System.out.println("=====gestion d'adherent =====");
        System.out.println("1. inscrption d'adherent");
        System.out.println("2. voir les adherents");
        System.out.println("3. modifier un adherent");
        System.out.println("4. supprimer un adherent");
        System.out.println("5. s'inscrire a une activite");
        System.out.println("6. s'inscrire a un centre");

        System.out.println("0. retour");

    }public static void displayInfoActivity(){
        System.out.println("=====gestion d'activités =====");
        System.out.println("1. crée une activité");
        System.out.println("2. voir les activités");
        System.out.println("3. modifier une activité");
        System.out.println("4. supprimer une activité");
        System.out.println("5. lié l'activite a un centre");
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
