package com.google.code.estore.domain.model.customer;

import com.google.code.estore.domain.shared.EntityFactory;

public class CustomerFactory implements EntityFactory{
	
	private static final String DEFAULT_NAME = "";
	
	private static final String DEFAULT_EMAIL = "";
	
	public static Customer createCustomer(String name, String email) {
		Customer c = getDefaultCustomer();
		c.setName(name);
		c.setEmail(email);
		return c;
	}
	
	private static Customer getDefaultCustomer() {
		Customer c = new Customer();
		c.setName(DEFAULT_NAME);
		c.setEmail(DEFAULT_EMAIL);
		return c;
	}
	
}
