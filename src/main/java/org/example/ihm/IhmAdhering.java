package org.example.ihm;

import org.example.entities.Activity;
import org.example.entities.Adhering;
import org.example.entities.Center;
import org.example.services.ActivityService;
import org.example.services.AdheringService;

import java.util.List;
import java.util.Scanner;

public class IhmAdhering {

    static AdheringService adheringService = new AdheringService();
    static Scanner scanner = new Scanner(System.in);





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
                    IHM.start();
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
        IhmCenter.seeAllCenter();
        id = scanner.nextInt();
        scanner.nextLine();
        Center center = IhmCenter.centerService.findById(id);
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
        IhmActivity.seeAllActivity();
        id = scanner.nextInt();
        scanner.nextLine();
        Activity activity = IhmActivity.activityService.findById(id);
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

    public static void displayInfoAdhering(){
        System.out.println("=====gestion d'adherent =====");
        System.out.println("1. inscrption d'adherent");
        System.out.println("2. voir les adherents");
        System.out.println("3. modifier un adherent");
        System.out.println("4. supprimer un adherent");
        System.out.println("5. s'inscrire a une activite");
        System.out.println("6. s'inscrire a un centre");

        System.out.println("0. retour");

    }
}
