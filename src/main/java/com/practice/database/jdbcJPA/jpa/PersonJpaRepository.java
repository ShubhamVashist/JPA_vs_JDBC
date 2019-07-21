package com.practice.database.jdbcJPA.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

import com.practice.database.jdbcJPA.entity.Person;

//Repository
//Transaction
@Repository
@Transactional
public class PersonJpaRepository {
	
	//connect to Database
	@PersistenceContext
	EntityManager entityManager;
	
	public Person findById(int id) {
		return entityManager.find(Person.class, id);// JPA
	}
	
	public Person update(Person person) {
		return entityManager.merge(person);
	}
	
	public Person insert(Person person) {
		return entityManager.merge(person);
	}
	
	public void deleteById(int id) {
		Person person = findById(id);
		entityManager.remove(person);
	}
	
	//JPQL for find All
	//Java persistence query language
	//we will use named queries
	public List<Person> findAll(){
		TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_person",Person.class);
		return namedQuery.getResultList();
	}

}
