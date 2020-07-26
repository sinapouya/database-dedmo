package com.sinasample.database.databasedemo.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class PartTimeEmploye extends Employee{
	
	protected PartTimeEmploye() {
		
	}
	public PartTimeEmploye(String name,BigDecimal hourlyWage) {
		super(name);
		this.hourlyWage = hourlyWage;
	}
	private BigDecimal hourlyWage;
}
