package com.sinasample.database.databasedemo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import com.sinasample.database.databasedemo.entity.Course;
import com.sinasample.database.databasedemo.jpa.CourseRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringJdbcApplication.class)
public class JPQLTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;
	
	@Test
	public void jpql_basic() {
		Query query=em.createQuery("select c from Course c");
		List resultList = query.getResultList();
		logger.info("select c from Course c {}",resultList);
	}
	@Test
	public void jpql_typed() {
		Query query=em.createNamedQuery("get_all_courses",Course.class);
		List<Course> resultList = query.getResultList();
		logger.info("select c from Course c {}",resultList);
	}
	@Test
	public void jpql_where() {
		Query query=em.createNamedQuery("get_all_jpa_courses");
		List<Course> resultList = query.getResultList();
		logger.info("select c from Course c where name like '%jpa' {}",resultList);
	}
	@Test
	public void jpql_where_course_without_student() {
		Query query=em.createQuery("select c from Course c where c.students is empty ",Course.class);
		List<Course> resultList = query.getResultList();
		logger.info(" select Course c where c.student is empty {}",resultList);
	}
	@Test
	public void jpql_courses_atleast_2students() {
		Query query=em.createQuery("select c from Course c where size(c.students)>2 ",Course.class);
		List<Course> resultList = query.getResultList();
		logger.info(" select c from Course c where size(c.students)>2 {}",resultList);
	}
	@Test
	public void jpql_courses_order_by_number_of_students() {
		Query query=em.createQuery("select c from Course c order by size(c.students) desc",Course.class);
		List<Course> resultList = query.getResultList();
		logger.info(" select c from Course c order by size(c.students) {}",resultList);
	}

}

 