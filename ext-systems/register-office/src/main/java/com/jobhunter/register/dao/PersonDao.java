package com.jobhunter.register.dao;

import com.jobhunter.register.domain.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class PersonDao {
    private EntityManager entityManager;

    public PersonDao() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
        entityManager = emf.createEntityManager();
    }

    public List<Person> findPersons() {
        Query query = entityManager.createNamedQuery("Person.findPersons");
        return query.getResultList();
    }
}
