package com.sinasample.database.databasedemo.jpa;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinasample.database.databasedemo.entity.Course;
import com.sinasample.database.databasedemo.entity.Passport;
import com.sinasample.database.databasedemo.entity.Student;
import org.slf4j.*;

@Repository
@Transactional
public class StudentRepository {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;
	
	public Student findById(Long id) {
		return em.find(Student.class, id);
	}
	public void deleteById(Long id) {
		Student Student = this.findById(id);
		em.remove(Student);
	}
	public Student save(Student Student) {
		
		if(Student==null) {
			em.persist(Student);
		}else {
			em.merge(Student);
		}
		return Student;
	}
	public void saveStudentWithPassport() {
		 Passport passport = new Passport("Z234212");
		 em.persist(passport);  
		 
		 Student student = new Student("Zack");
		 student.setPassport(passport);
		 em.persist(student);
		
		
	}
	@Transactional
	public void someTestforPersistentContext() {
		Student student = em.find(Student.class, 2001l);
		
		Passport passport = student.getPassport();
		
		passport.setNumber("N123786");
		
		student.setName("SINA-updated");
//		em.persist(student);
//		em.persist(passport);
	}
	
	@Transactional
	public void retrivePassportAndAssosiateStudent() {
		Passport passport = em.find(Passport.class,4001l);
		logger.info("passport is -> {} ",passport);
		logger.info("related student is -> {} ",passport.getStudent());
		
	}
	@Transactional
	public void insertStudentAndCourse(Student student,Course course) {

		student.addCourse(course);
		course.addStudent(student);
		
		em.persist(student);
		em.persist(course);
	}
	
}
