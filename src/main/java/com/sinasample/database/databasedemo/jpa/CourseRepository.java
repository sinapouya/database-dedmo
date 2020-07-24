package com.sinasample.database.databasedemo.jpa;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinasample.database.databasedemo.entity.Course;
import org.slf4j.*;

@Repository
@Transactional
public class CourseRepository {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
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
	public void aroundEntityManager() {
		logger.info("aroundEntityManager start");
		Course course = new Course("angular course");
		em.persist(course);
//		em.flush();
//		em.detach(course);
		course.setName("angular course updated");
		
	}
}
