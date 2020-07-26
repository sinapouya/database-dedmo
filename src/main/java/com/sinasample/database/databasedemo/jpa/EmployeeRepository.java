package com.sinasample.database.databasedemo.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinasample.database.databasedemo.entity.Employee;

@Repository
@Transactional
public class EmployeeRepository {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private EntityManager em;
	
	public Employee findById(Long id) {
		return em.find(Employee.class, id);
	}
	public void save(Employee employee) {
		if(employee.getId()==null){
			em.persist(employee);	
		}else {
			em.merge(employee);	
		}
	}
	public List<Employee> retriveAll(){
		return em.createQuery("select e from Employee e",Employee.class).getResultList();
	}
}
