package com.sinasample.database.databasedemo.jpa;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
}
