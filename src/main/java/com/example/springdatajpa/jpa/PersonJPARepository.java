package com.example.springdatajpa.jpa;

import com.example.springdatajpa.entity.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class PersonJPARepository {

    //connect to database
    @PersistenceContext
    EntityManager entityManager;

    public List<Person> findAll(){

       TypedQuery<Person> personTypedQuery = entityManager.createNamedQuery("find_all_persons",Person.class);

        return personTypedQuery.getResultList();
    }

    public Person findById(int id){
        return entityManager.find(Person.class,id);
    }

    public Person update(Person person){
        return entityManager.merge(person);
    }

    public Person insert(Person person){
        return entityManager.merge(person);
    }

    public void deleteById(int id){
        Person person = findById(id);
        entityManager.remove(person);
    }

}
