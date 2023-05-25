package org.example.services;

import org.example.entities.Activity;
import org.example.entities.Center;
import org.example.interfaces.Repository;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class ActivityService extends MainService implements Repository<Activity> {

    public  boolean joinActivityToCenter(Activity activity){
        if (activity != null){

            session = sessionFactory.openSession();
            session.beginTransaction();




            session.update(activity);
            session.getTransaction().commit();
            session.close();
            System.out.println("activite lie a la salle : " + activity.getCenteractivity().getName());
            return true;
        } else {
            System.out.println("erreur");
            return false;
        }
    }
    @Override
    public boolean create(Activity activity) {
        if (activity != null){
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(activity);
            session.getTransaction().commit();
            session.close();
            System.out.println("activité ajouter");
            return true;

        } else {
            System.out.println("aucune valeur dans l'activite");
            return false;
        }
    }

    @Override
    public boolean update(Activity activity) {
        if (activity != null){
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(activity);
            session.getTransaction().commit();
            session.close();

            return true;
        } else {
            System.out.println("aucune valeur dans l'activite");
            return false;
        }
    }

    @Override
    public boolean delete(Activity activity) {
        if (activity != null){
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(activity);
            session.getTransaction().commit();
            session.close();

            return true;
        } else {
            System.out.println("problème de suppression");
            return false;
        }
    }


    @Override
    public Activity findById(int id) {
        Activity activity = null;
        session = sessionFactory.openSession();
        activity  = (Activity) session.get(Activity.class,id);
        session.close();
        if (activity == null){
            System.out.println("activite introuvable verifier l'id taper");
        }
        return activity;
    }

    @Override
    public List<Activity> findAll() {
        List<Activity> activities = new ArrayList<>();
        session = sessionFactory.openSession();
        Query<Activity> centerQuery = session.createQuery("from Activity ");
        activities = centerQuery.list();
        session.close();

        return activities;
    }
    public void end(){


        sessionFactory.close();
    }
}
