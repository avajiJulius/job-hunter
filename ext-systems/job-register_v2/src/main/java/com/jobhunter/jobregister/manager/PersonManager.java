package com.jobhunter.jobregister.manager;

import com.jobhunter.jobregister.domain.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;



public class PersonManager {

    public static void main(String[] args) {
        SessionFactory sf = buildSessionFactory();
        Session session = sf.openSession();

        session.getTransaction().begin();

        Person p = new Person();
        p.setFirstName("Alexandr");
        p.setLastName("Matushikn");

        Long id = (Long) session.save(p);

        session.getTransaction().commit();
        session.close();
    }

    private static SessionFactory buildSessionFactory() {
        try {
            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml").build();

            Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();

            return metadata.getSessionFactoryBuilder().build();
        } catch (Throwable ex) {

            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
}
