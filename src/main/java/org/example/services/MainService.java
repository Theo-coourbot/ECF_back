package org.example.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public abstract class MainService {

    StandardServiceRegistry registry;
    SessionFactory sessionFactory;
    Session session;

    public MainService() {
        registry = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory =new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }
}
