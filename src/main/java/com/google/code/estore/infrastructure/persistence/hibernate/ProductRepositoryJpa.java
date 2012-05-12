package com.google.code.estore.infrastructure.persistence.hibernate;

import org.springframework.data.repository.CrudRepository;

import com.google.code.estore.domain.model.product.Product;

public interface ProductRepositoryJpa extends CrudRepository<Product, Long>, ProductRepositoryJpaCustom{
	
	public Product findByName(String name);
	
	public Product findById(Long id);
	
}
