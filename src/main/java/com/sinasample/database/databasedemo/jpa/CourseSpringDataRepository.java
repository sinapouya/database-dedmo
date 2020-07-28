package com.sinasample.database.databasedemo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sinasample.database.databasedemo.entity.Course;

public interface CourseSpringDataRepository extends JpaRepository<Course, Long>{

}
