package com.sinasample.database.databasedemo.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.lang.Nullable;

import jdk.jfr.Timestamp;

@Entity
@Table(name="Course")
@NamedQueries(
		value = {
				@NamedQuery(name = "get_all_courses",query = "select c from Course c"),
				@NamedQuery(name = "get_all_jpa_courses",query = "select c from Course c where name like '%jpa'")

				
		})
public class Course {
	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String name;

	@OneToMany(mappedBy = "course")
	private List<Review> reviews=new ArrayList();
	
	public Course() {
	}
	public Course(String name) {
		super();
		this.name = name;
	}
	
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	@UpdateTimestamp
	private LocalDateTime lastUpdatedDate;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Review> getReviews() {
		return reviews;
	}
	public void addReview(Review review) {
		this.reviews.add(review);
	}
	public void removeReview(Review review) {
		this.reviews.remove(review);
	}
	public Long getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + "]";
	}
	
	
}
