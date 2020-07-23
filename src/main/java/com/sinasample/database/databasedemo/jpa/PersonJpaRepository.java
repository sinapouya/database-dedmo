package com.sinasample.database.databasedemo.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.sinasample.database.databasedemo.entity.Person;

@Repository
@Transactional
public class PersonJpaRepository {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public Person findById(int id) {
		return entityManager.find(Person.class, id);
	}
	public Person create(Person person) {
		return entityManager.merge(person);
	}
	public Person update(Person person) {
		return entityManager.merge(person);
	}
	public void deleteById(int id) {
		Person person = this.findById(id);
		entityManager.remove(person);
	}
	public List<Person> findAll(){
		TypedQuery<Person> typedQuery = 
				entityManager.createNamedQuery("find_all_persons",Person.class);
		return typedQuery.getResultList();
	}
}
