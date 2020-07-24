package com.sinasample.database.databasedemo;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

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
public class NativeQueryTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;
	
	@Test
	public void native_queries_basic() {
		Query query=em.createNativeQuery("select * from Course c",Course.class);
		List resultList = query.getResultList();
		logger.info("select * from Course c{}",resultList);
	}
	@Test
	public void native_queries_basic_with_parameter() {
		Query query=em.createNativeQuery("select * from Course c where c.id=?",Course.class);
		query.setParameter(1, 10001l);
		List resultList = query.getResultList();
		logger.info("select * from Course c{}",resultList);
	}
	@Test
	public void native_queries_basic_with_named_parameter() {
		Query query=em.createNativeQuery("select * from Course c where c.id=:id",Course.class);
		query.setParameter("id", 10001l);
		List resultList = query.getResultList();
		logger.info("select * from Course c{}",resultList);
	}
	@Test
	@Transactional
	public void native_queries_for_update() {
		Query query=em.createNativeQuery("update Course set last_updated_date=sysdate()",Course.class);
		int numOfRows= query.executeUpdate();
		logger.info("update num of rows {}",numOfRows);
	}	

}


