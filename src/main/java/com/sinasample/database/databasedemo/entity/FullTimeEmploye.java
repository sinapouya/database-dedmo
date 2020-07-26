package com.sinasample.database.databasedemo.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class FullTimeEmploye extends Employee{
	
	protected FullTimeEmploye() {
		
	}
	public FullTimeEmploye(String name,BigDecimal salary) {
		super(name);
		this.salary = salary;
	}
	private BigDecimal salary;
}
