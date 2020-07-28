package com.sinasample.database.databasedemo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import com.sinasample.database.databasedemo.entity.Course;
import com.sinasample.database.databasedemo.entity.Student;
import com.sinasample.database.databasedemo.jpa.CourseRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringJdbcApplication.class)
public class CriteriaQueryTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;
	
	@Test
	public void criteria_basic() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		
		Root<Course> courseRoot = cq.from(Course.class);
				
		Query query = 
				em.createQuery(cq.select(courseRoot));
		
		List resultList = query.getResultList();
		logger.info("select with criteria {}",resultList);
	}
	@Test
	public void criteria_where() {
//		select c from Course c where c.name like %jpa%
//		1)use criteriaBuilder to create criteriaQuery base on object
		CriteriaBuilder cb =em.getCriteriaBuilder();
		
		CriteriaQuery<Course> criteriaQuery = cb.createQuery(Course.class);
		
//		2)define root for table which are involved
		Root<Course> courseRoot = criteriaQuery.from(Course.class);
		
//		3)define predicates etc using citeria builder
		Predicate likePredicate =cb.like(courseRoot.get("name"), "%jpa%");
		criteriaQuery.where(likePredicate);
		
		
		TypedQuery<Course> query =  em.createQuery(criteriaQuery.select(courseRoot));
		List<Course> resultList = query.getResultList();			
		
		logger.info("typed query {} ",resultList);
	}
	
	@Test
	public void criteria_courses_without_student() {
//		select c from Course c where c.students is empty 
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		
		CriteriaQuery<Course> criteriaQuery = criteriaBuilder.createQuery(Course.class);
		
		
		Root<Course> courseRoot = criteriaQuery.from(Course.class);
		
		Predicate isEmptyPredicate = criteriaBuilder.isEmpty(courseRoot.get("students"));
		
		criteriaQuery.where(isEmptyPredicate);
		
		TypedQuery<Course> query = em.createQuery(criteriaQuery.select(courseRoot));
	
		List<Course> resultList = query.getResultList();
		
		logger.info("typed query {} ",resultList);
	}
	
	@Test
	public void join() {
//		select c from Course c join c.students s
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		
		CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Course.class);
		
		
		Root<Course> courseRoot = criteriaQuery.from(Course.class);
		
		Join<Object,Object> join = courseRoot.join("students");
		
		TypedQuery<Course> query = em.createQuery(criteriaQuery.select(courseRoot));
		
		List<Course> resultList = query.getResultList();
		
		logger.info("join query {} ",resultList);
		
	}
	
}

 