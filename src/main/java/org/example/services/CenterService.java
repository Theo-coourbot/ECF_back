package org.example.services;

import org.example.entities.Center;
import org.example.interfaces.Repository;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class CenterService extends MainService implements Repository<Center>   {

    public CenterService() {
        super();
    }

    @Override
    public boolean create(Center center) {
        if (center != null){
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(center);
        session.close();
        return true;

        } else {
            System.out.println("aucune valeur dans le centre");
            return false;
        }
    }

    @Override
    public boolean update(Center center) {
        if (center != null){
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(center);
        session.getTransaction().commit();
        session.close();

        return true;
        } else {
            System.out.println("aucune valeur dans le centre");
            return false;
        }
    }

    @Override
    public boolean delete(Center center) {

        if (center != null){
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(center);
            session.getTransaction().commit();
            session.close();

            return true;
        } else {
            System.out.println("problème de suppression");
            return false;
        }
    }

    @Override
    public Center findById(int id) {
        Center center = null;
        session = sessionFactory.openSession();
        center  = (Center) session.get(Center.class,id);
        session.close();
        if (center == null){
            System.out.println("centre introuvable verifier l'id taper");
        }
        return center;
    }

    @Override
    public List<Center> findAll() {
        List<Center> centers = new ArrayList<>();
        session = sessionFactory.openSession();
        Query<Center> centerQuery = session.createQuery("from Center ");
        centers = centerQuery.list();
        session.close();

        return centers;
    }
}
