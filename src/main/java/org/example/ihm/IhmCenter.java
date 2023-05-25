package org.example.ihm;

import org.example.entities.Center;
import org.example.services.CenterService;

import java.util.List;
import java.util.Scanner;

public class IhmCenter {

    static Scanner scanner =new Scanner(System.in);
    static CenterService centerService = new CenterService();

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
                    IHM.start();
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




    public static void displayInfoCenter(){
        System.out.println("=====gestion des centre =====");
        System.out.println("1. enregistrer un nouveau centre");
        System.out.println("2. voir les centres");
        System.out.println("3. modifier un centre");
        System.out.println("4. supprimer un centre");
        System.out.println("0. retour");

    }
}
