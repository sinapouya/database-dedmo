package com.sinasample.database.databasedemo;

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

import com.sinasample.database.databasedemo.entity.Course;
import com.sinasample.database.databasedemo.entity.Passport;
import com.sinasample.database.databasedemo.entity.Student;
import com.sinasample.database.databasedemo.jpa.CourseRepository;
import com.sinasample.database.databasedemo.jpa.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringJdbcApplication.class)
public class CourseRepositoryTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseRepository courseRepo;
	@Autowired
	private StudentRepository studentRepository;
	@Test
	public void findById_test() {
		Course course = courseRepo.findById(10001l);
		assertEquals("Simple jpa sample",course.getName());
	}
	
	@Test
	public void deleteById_test() {
		courseRepo.deleteById(10002l);
		assertNotNull( courseRepo.findById(10002l));
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
