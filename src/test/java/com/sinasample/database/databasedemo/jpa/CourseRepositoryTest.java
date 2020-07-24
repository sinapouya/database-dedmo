package com.sinasample.database.databasedemo.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.sinasample.database.databasedemo.SpringJdbcApplication;
import com.sinasample.database.databasedemo.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringJdbcApplication.class)
public class CourseRepositoryTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseRepository courseRepo;
	@Test
	public void findById_test() {
		Course course = courseRepo.findById(10001l);
		assertEquals("Simple jpa sample",course.getName());
	}
	
	@Test
	@DirtiesContext
	public void deleteById_test() {
		courseRepo.deleteById(10002l);
		assertNull( courseRepo.findById(10002l));
	}
	@Test
	@DirtiesContext
	public void save_test() {
		Course course = courseRepo.findById(10002l);
		assertEquals("Simple spring sample",course.getName());
		course.setName("Simple spring sample updated");
		courseRepo.save(course);
		
		Course courseUpdated = courseRepo.findById(10002l);
		assertEquals("Simple spring sample updated",courseUpdated.getName());
	}
	@Test
	@DirtiesContext
	public void aroundEntityManager_test() {
		courseRepo.aroundEntityManager();
	}
}
