package com.google.code.estore.domain.model.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.code.estore.infrastructure.persistence.hibernate.ProductRepositoryJpa;

@Component
public class ProductRepository  {
	
	@Autowired
	private ProductRepositoryJpa productJpaRepository;

	public Product save(Product product) {
		return productJpaRepository.save(product);
	}

	public Product findByName(String name) {
		
		return productJpaRepository.findByName(name);
	}
	
	public Iterable<Product> findAll() {
		return productJpaRepository.findAll();
	}
	
	public List<Product> findTopXLastCreatedProducts(int x){
		return productJpaRepository.findTopXLastCreatedProducts(x);
	}
	
}
