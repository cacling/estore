package com.google.code.estore.domain.model.product;

import java.util.Date;

import org.springframework.util.Assert;

import com.google.code.estore.domain.shared.EntityFactory;
import com.google.code.estore.infrastructure.util.DateUtil;

public class ProductFactory implements EntityFactory{
	
	private static final String DEFAULT_NAME = "";
	
	private static final String DEFAULT_DESCRIPTION = "";
	
	private static final String DEFAULT_IMAGE = "";
	
	private static final Double DEFAULT_UNIT_PRICE = Double.valueOf(0);
	
	private static final Date DEFAULT_CREATED_DATE = new Date();
	
	public static Product createProduct(String name, double unitPrice) {
		Product p = getDefaultProduct();
		p.setName(name);
		p.setUnitPrice(unitPrice);
		return p;
	}
	
//	public static Product createProduct(String name, String description, String image, double unitPrice, double salePrice, String createdDate) {
//		Product p = getDefaultProduct();
//		p.setName(name);
//		p.setDescription(description);
//		p.setImage(image);
//		p.setUnitPrice(unitPrice);
//		p.setSalePrice(salePrice);
//		DateUtil.parseDate(createdDate);
//		return p;
//	}
	
	private static Product getDefaultProduct() {
		Product p = new Product();
		p.setName(DEFAULT_NAME);
		p.setDescription(DEFAULT_DESCRIPTION);
		p.setImage(DEFAULT_IMAGE);
		p.setUnitPrice(DEFAULT_UNIT_PRICE);
		p.setCreatedDate(DEFAULT_CREATED_DATE);
		return p;
	}
	
	public static ProductBuilder getProductBuilder() {
		return new ProductFactory().new ProductBuilder();
	}

	public class ProductBuilder {
		
		private Product product = new Product();
		
		public ProductBuilder(){
		}
		
		public ProductBuilder(Product product){
			this.product = product;
		}
		
		public ProductBuilder withId(Long id){
			product.setId(id);
			return this;
		}
		
		public ProductBuilder withName(String name){
			product.setName(name);
			return this;
		}
		
		public ProductBuilder withDescription(String description){
			product.setDescription(description);
			return this;
		}
		
		public ProductBuilder withImage(String image){
			product.setImage(image);
			return this;
		}
		
		public ProductBuilder withUnitPrice(double unitPrice){
			product.setUnitPrice(unitPrice);
			return this;
		}
		
		public ProductBuilder withSalePrice(double salePrice){
			product.setSalePrice(salePrice);
			return this;
		}
		
		public ProductBuilder withCreatedDate(String createdDate){
			DateUtil.parseDate(createdDate);
			return this;
		}
		
		public Product build(){
			//validate
			Assert.hasLength(product.getName(),"product name should not empty");
			Assert.notNull(product.getUnitPrice(),"product unitPrice should not empty");
			return product;
		}

	}
	
}
