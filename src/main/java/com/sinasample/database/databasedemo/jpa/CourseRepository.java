package com.sinasample.database.databasedemo.jpa;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinasample.database.databasedemo.entity.Course;

@Repository
@Transactional
public class CourseRepository {
	@Autowired
	EntityManager em;
	
	public Course findById(Long id) {
		return em.find(Course.class, id);
	}
	public void deleteById(Long id) {
		Course course = this.findById(id);
		em.remove(course);
	}
	public Course save(Course course) {
		
		if(course==null) {
			em.persist(course);
		}else {
			em.merge(course);
		}
		return course;
	}
}
