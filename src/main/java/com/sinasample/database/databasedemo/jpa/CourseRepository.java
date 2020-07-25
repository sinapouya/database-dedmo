package com.sinasample.database.databasedemo.jpa;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinasample.database.databasedemo.entity.Course;
import com.sinasample.database.databasedemo.entity.Review;

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
		 Course course = new Course("new course");
		 em.persist(course);  
		 
		 Course course1 = findById(10003l);
		 course1.setName("Simple spring boot sample-updated");
	}
	public void addReviewsToCourse() {
		Course course = this.findById(10003l);
		
		Review review1 = new Review("5","Awsoome");
		Review review2 = new Review("4","booring");
		
		course.addReview(review1);
		review1.setCourse(course);
		
		course.addReview(review2);
		review2.setCourse(course);
		
		em.persist(review1);
		em.persist(review2);
	}
}
