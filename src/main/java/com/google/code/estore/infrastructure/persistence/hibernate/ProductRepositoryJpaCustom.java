package com.google.code.estore.infrastructure.persistence.hibernate;

import java.util.List;

import com.google.code.estore.domain.model.product.Product;

public interface ProductRepositoryJpaCustom {

	public List<Product> myCustomBatchOperation(String xxxx);
	
	public List<Product> findTopXLastCreatedProducts(int x);
	
	public List<Product> findTopXOrderedProducts(int x);
	
	public List<Product> findTopXDiscountMostProducts(int x);

}
