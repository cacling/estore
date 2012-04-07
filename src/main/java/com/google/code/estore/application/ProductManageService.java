package com.google.code.estore.application;

import java.util.List;

import org.springframework.stereotype.Component;

import com.google.code.estore.domain.model.customer.Customer;
import com.google.code.estore.domain.model.product.Product;
import com.google.code.estore.domain.shared.RepositoryFactory;


@Component
public class ProductManageService {
	
	
	//bestPrice
	
	//bestselling 
	
	//new product
	
	//guess what you like
	
	
	public List<Product> getBigDiscountProducts(int amount) {
		return null;
	}
	
	
	public List<Product> getHotSalesProducts(int amount) {
		return null;
	}
	
	public List<Product> getLatest4Products() {
		int amount = 4;
		return RepositoryFactory.getProductRepository().findTopXLastCreatedProducts(amount);
	}
	
	public List<Product> getCustomerFavourProducts(int amount, Customer customer) {
		return null;
	}

}
