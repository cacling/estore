package com.google.code.estore.domain.model.product;

import java.util.ArrayList;
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
	
	public Product findById(Long id) {
		return productJpaRepository.findById(id);
	}
	
	public Iterable<Product> findAll() {
		return productJpaRepository.findAll();
	}
	
	public List<Product> findTopXLastCreatedProducts(int x){
		return productJpaRepository.findTopXLastCreatedProducts(x);
	}
	
	public List<Product> findTopXOrderedProducts(int x){
		return productJpaRepository.findTopXOrderedProducts(x);
	}
	
	public List<Product> findTopXDiscountMostProducts(int x){
		return productJpaRepository.findTopXDiscountMostProducts(x);
	}
	
	//TODO temp,find with customer's hobbie
	public List<Product> findTopXRecommendProducts(int x){
		Iterable<Product> products = productJpaRepository.findAll();
		List<Product> recommendProducts = new ArrayList<Product>();
			for (Product product : products) {
				if (x-- > 0) {
					recommendProducts.add(product);
				}
			}
		return recommendProducts;
	}
	
	
	
	
}
