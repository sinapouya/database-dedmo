package com.sinasample.database.databasedemo.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sinasample.database.databasedemo.entity.Course;

public interface CourseSpringDataRepository extends JpaRepository<Course, Long>{
	List<Course> findByName(String name);
	List<Course> countByName(String name);
	List<Course> findByNameAndId(String name,Long id);
	List<Course> findByNameOrderByNameDesc(String name);
	List<Course> deleteByName(String name);
	
	@Query("select c from Course c where name like '%jpa'")
	List<Course> coursesWithnameLikeJpa();
	
	@Query(value="select * from Course c where name like '%jpa'",
			nativeQuery = true)
	List<Course> coursesWithnameLikeJpaNativeQuery();
	
	@Query(name = "get_all_jpa_courses")
	List<Course> coursesWithnamedQuery();
	
}
