package com.google.code.estore.application;

import java.util.List;

import org.springframework.stereotype.Component;

import com.google.code.estore.domain.model.customer.Customer;
import com.google.code.estore.domain.model.product.Product;
import com.google.code.estore.domain.shared.RepositoryFactory;


@Component
public class ProductManageService {
	
	public List<Product> get4BestSellingProducts() {
		int amount = 4;
		return RepositoryFactory.getProductRepository().findTopXOrderedProducts(amount);
	}
	
	public List<Product> get4LatestProducts() {
		int amount = 4;
		return RepositoryFactory.getProductRepository().findTopXLastCreatedProducts(amount);
	}
	
	public List<Product> getCustomerFavourProducts(int amount, Customer customer) {
		return null;
	}
	
	public List<Product> get4BestPriceProducts() {
		int amount = 4;
		return RepositoryFactory.getProductRepository().findTopXDiscountMostProducts(amount);
	}
	
	public List<Product> get10RecommendProducts() {
		int amount = 10;
		return RepositoryFactory.getProductRepository().findTopXRecommendProducts(amount);
	}
	
}
