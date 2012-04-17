package com.google.code.estore.infrastructure.persistence.hibernate;

import org.springframework.data.repository.CrudRepository;

import com.google.code.estore.domain.model.customer.Customer;

public interface CustomerRepositoryJpa extends CrudRepository<Customer, Long>{
	public Customer findByName(String name);
	
	public Customer findByNameAndPassword(String name, String password);
	
}
