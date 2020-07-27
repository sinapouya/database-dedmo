package com.sinasample.database.databasedemo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
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
	
}

 