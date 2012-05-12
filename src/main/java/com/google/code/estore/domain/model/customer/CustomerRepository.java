package com.google.code.estore.domain.model.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.code.estore.infrastructure.persistence.hibernate.CustomerRepositoryJpa;

@Component
public class CustomerRepository {
	
	@Autowired
	private CustomerRepositoryJpa customerRepositoryJpa;

	public Customer save(Customer customer) {
		return customerRepositoryJpa.save(customer);
	}

	public Customer findByName(String name) {
		return customerRepositoryJpa.findByName(name);
	}
	
	public Customer findByNameAndPassword(String name, String password){
		return customerRepositoryJpa.findByNameAndPassword(name, password);
	}
	
}
