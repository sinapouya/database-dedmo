package com.sinasample.database.databasedemo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.SortDefinition;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.sinasample.database.databasedemo.entity.Course;
import com.sinasample.database.databasedemo.entity.Passport;
import com.sinasample.database.databasedemo.entity.Student;
import com.sinasample.database.databasedemo.jpa.CourseRepository;
import com.sinasample.database.databasedemo.jpa.CourseSpringDataRepository;
import com.sinasample.database.databasedemo.jpa.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringJdbcApplication.class)
public class CourseSpringDataRepositoryTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseSpringDataRepository courseRepo;
	@Test
	public void findById_CoursePresent() {
		Optional<Course> courseOptinal = courseRepo.findById(10001l);
		assertTrue("{}",courseOptinal.isPresent());
	}
	@Test
	public void findById_CourseNotPresent() {
		Optional<Course> courseOptinal = courseRepo.findById(20001l);
		assertFalse("{}",courseOptinal.isPresent());
	}
	@Test
	public void springDataRepositoryTest() {
		Course course = new Course("learning spring data ");
		courseRepo.save(course);
		course.setName("learning spring data - updated");
		courseRepo.save(course);
		
	}
	@Test
	public void someMethodsInSpringDataRepo() {
		
		logger.info(" all courses {} ",courseRepo.findAll());		
		logger.info(" count all courses {} ",courseRepo.count());
		
	}
	@Test 
	public void sort() {
		Sort sort = Sort.by(Sort.Direction.DESC,"name");
		logger.info("courses with sort -> {} ",courseRepo.findAll(sort));
		
	}
	@Test
	public void paggination() {
		PageRequest pageRequest = PageRequest.of(0, 3);
		Page<Course> firstPage = courseRepo.findAll(pageRequest);
		logger.info("first page {}",firstPage.getContent());
		
		Pageable secondPageable = firstPage.nextPageable();
		Page<Course> secondPage = courseRepo.findAll(secondPageable);
		logger.info("second page {}",secondPage.getContent());
		
	}
}
