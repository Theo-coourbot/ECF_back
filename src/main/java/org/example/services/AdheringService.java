package org.example.services;

import org.example.entities.Activity;
import org.example.entities.Adhering;
import org.example.interfaces.Repository;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class AdheringService extends MainService implements Repository<Adhering> {



    public boolean joinAdheringToCenter(Adhering adhering){
        if (adhering != null){

            session = sessionFactory.openSession();
            session.beginTransaction();




            session.update(adhering);
            session.getTransaction().commit();
            session.close();
            System.out.println("adhérant inscris a la salle : " + adhering.getCenter().getName());
            return true;
        } else {
            System.out.println("erreur");
            return false;
        }
    }
    public boolean addAdheringActivity(Adhering adhering){
        if (adhering != null){
//            System.out.println(activity.getIdCours());
//            System.out.println(adhering.getId());
            session = sessionFactory.openSession();
            session.beginTransaction();




            session.update(adhering);
            session.getTransaction().commit();
            session.close();
            System.out.println("adhérant inscris a l'activite");
            return true;
        } else {
            System.out.println("erreur");
            return false;
        }
    }
    @Override
    public boolean create(Adhering adhering) {
        if (adhering != null){
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(adhering);
            session.getTransaction().commit();
            session.close();
            System.out.println("adhérant ajouter");
            return true;

        } else {
            System.out.println("aucune valeur a l'adherant");
            return false;
        }
    }

    @Override
    public boolean update(Adhering adhering) {
        if (adhering != null){
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(adhering);
            session.getTransaction().commit();
            session.close();

            return true;
        } else {
            System.out.println("aucune  valeur a l'adherant");
            return false;
        }
    }

    @Override
    public boolean delete(Adhering adhering) {
        if (adhering != null){
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(adhering);
            session.getTransaction().commit();
            session.close();

            return true;
        } else {
            System.out.println("problème de suppression");
            return false;
        }
    }

    @Override
    public Adhering findById(int id) {
        Adhering adhering = null;
        session = sessionFactory.openSession();
        adhering  = (Adhering) session.get(Adhering.class,id);
        session.close();
        if (adhering == null){
            System.out.println("adherant introuvable verifier l'id taper");
        }
        return adhering;
    }

    @Override
    public List<Adhering> findAll() {
        List<Adhering> adheringList = new ArrayList<>();
        session = sessionFactory.openSession();
        Query<Adhering> centerQuery = session.createQuery("from Adhering ");
        adheringList = centerQuery.list();
        session.close();

        return adheringList;
    }
    public void end(){
        sessionFactory.close();
    }
}
