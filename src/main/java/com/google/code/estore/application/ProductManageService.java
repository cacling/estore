package com.google.code.estore.application;

import java.util.List;

import org.springframework.stereotype.Component;

import com.google.code.estore.domain.model.customer.Customer;
import com.google.code.estore.domain.model.product.Product;
import com.google.code.estore.domain.shared.RepositoryFactory;


@Component
public class ProductManageService {
	
	public List<Product> get4BestSellingProducts() {
		int quantity = 4;
		return RepositoryFactory.getProductRepository().findTopXOrderedProducts(quantity);
	}
	
	public List<Product> get4LatestProducts() {
		int quantity = 4;
		return RepositoryFactory.getProductRepository().findTopXLastCreatedProducts(quantity);
	}
	
	public List<Product> getCustomerFavourProducts(int quantity, Customer customer) {
		return null;
	}
	
	public List<Product> get4BestPriceProducts() {
		int quantity = 4;
		return RepositoryFactory.getProductRepository().findTopXDiscountMostProducts(quantity);
	}
	
	public List<Product> get10RecommendProducts() {
		int quantity = 10;
		return RepositoryFactory.getProductRepository().findTopXRecommendProducts(quantity);
	}
	
}
