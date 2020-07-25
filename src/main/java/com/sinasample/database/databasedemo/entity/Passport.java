package com.sinasample.database.databasedemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Passport {
	@Id
	@GeneratedValue
	private long id;
	@Column(nullable = false)
	private String number;
	public Passport() {
		super();
	}
	public Passport(String number) {
		super();
		this.number = number;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "Passport [id=" + id + ", number=" + number + "]";
	}
	
	

}
