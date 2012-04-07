package com.google.code.estore.domain.shared;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.code.estore.domain.model.customer.CustomerRepository;
import com.google.code.estore.domain.model.product.ProductRepository;

@Component
public class RepositoryFactory {
	
	private static ProductRepository productRepository;
	
	private static CustomerRepository customerRepository;

	public static ProductRepository getProductRepository() {
		return productRepository;
	}

	@Autowired
	public void setProductRepository(ProductRepository productRepository) {
		RepositoryFactory.productRepository = productRepository;
	}

	public static CustomerRepository getCustomerRepository() {
		return customerRepository;
	}

	@Autowired
	public void setCustomerRepository(CustomerRepository customerRepository) {
		RepositoryFactory.customerRepository = customerRepository;
	}
	
	
	
	

}
