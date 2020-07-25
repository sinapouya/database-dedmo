package com.sinasample.database.databasedemo.jpa;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinasample.database.databasedemo.entity.Passport;
import com.sinasample.database.databasedemo.entity.Student;

import org.slf4j.*;

@Repository
@Transactional
public class PassportRepository {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;
	
	public Passport findById(Long id) {
		return em.find(Passport.class, id);
	}
	public void deleteById(Long id) {
		Passport Passport = this.findById(id);
		em.remove(Passport);
	}
	public Passport save(Passport Passport) {
		
		if(Passport==null) {
			em.persist(Passport);
		}else {
			em.merge(Passport);
		}
		return Passport;
	}
	
}
