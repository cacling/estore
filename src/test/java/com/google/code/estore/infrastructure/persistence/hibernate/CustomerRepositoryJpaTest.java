package com.google.code.estore.infrastructure.persistence.hibernate;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.google.code.estore.domain.model.customer.Customer;
import com.google.code.estore.domain.model.customer.CustomerFactory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:/estore-infrastructure-persistence.xml",
		"classpath:/applicationContext-test.xml" })
@Transactional
public class CustomerRepositoryJpaTest 
		 {
	
	@Autowired
	protected CustomerRepositoryJpa customerRepositoryJpa;

	@Before
	public void prepareData() {
	}
	
	@Test 
	public void findByName() {
		customerRepositoryJpa.save(CustomerFactory.createCustomer("customer1","customer1@163.com"));
		customerRepositoryJpa.save(CustomerFactory.createCustomer("customer2","customer2@163.com"));
		customerRepositoryJpa.save(CustomerFactory.createCustomer("customer3","customer3@163.com"));
		Customer customer = customerRepositoryJpa.findByName("customer2");
		Assert.assertNotNull(customer.getId());
	}
	
	

}
