package com.sinasample.database.databasedemo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sinasample.database.databasedemo.entity.Course;
import com.sinasample.database.databasedemo.entity.Person;
import com.sinasample.database.databasedemo.jpa.CourseRepository;
import com.sinasample.database.databasedemo.jpa.PersonJpaRepository;

@SpringBootApplication
public class SpringJdbcApplication implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private PersonJpaRepository personJpaRepository;
	@Autowired
	private CourseRepository courseRepository;
	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		logger.info("find one user {}" , personJpaRepository.findById(10001));
//		logger.info("create  user {}" , personJpaRepository.create(new Person("ali","istanbul",new Date())));
//		logger.info("update one user {}" , personJpaRepository.update(new Person(10001,"sina","tehran edited",new Date())));
//		logger.info("find All users {}" , personJpaRepository.findAll());
		Course course = courseRepository.findById(10001l);
		logger.info("course number 10001 is {}",course);
	}
	

}
