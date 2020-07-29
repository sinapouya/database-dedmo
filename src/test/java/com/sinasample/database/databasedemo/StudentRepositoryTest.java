package com.sinasample.database.databasedemo;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sinasample.database.databasedemo.entity.Passport;
import com.sinasample.database.databasedemo.entity.Student;
import com.sinasample.database.databasedemo.jpa.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringJdbcApplication.class)
public class StudentRepositoryTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private EntityManager em;
	@Test
	@Transactional
	public void retriveStudentAndPasswordDetails() {
		Student student = studentRepository.findById(2001l);
		Passport passport = student.getPassport();
		
		logger.info("student is {} ",student);
		logger.info("passport is {} ",passport);
		
	}
	@Test
	@Transactional
	public void someTestforPersistentContext() {
		Student student = em.find(Student.class, 2001l);
		
		Passport passport = student.getPassport();
		
		passport.setNumber("N123786");
		
		student.setName("SINA-updated");
		em.persist(student);
		em.persist(passport);
	}
}
