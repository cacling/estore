package com.google.code.estore.domain.model.product;

import java.util.Date;

import org.apache.commons.lang.time.DateUtils;

import com.google.code.estore.domain.shared.EntityFactory;
import com.google.code.estore.domain.shared.util.DateUtil;

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
	
	public static Product createProduct(String name, String description, String image, double unitPrice, double salePrice, String createdDate) {
		Product p = getDefaultProduct();
		p.setName(name);
		p.setDescription(description);
		p.setImage(image);
		p.setUnitPrice(unitPrice);
		p.setSalePrice(salePrice);
		DateUtil.parseDate(createdDate);
		return p;
	}
	
	private static Product getDefaultProduct() {
		Product p = new Product();
		p.setName(DEFAULT_NAME);
		p.setDescription(DEFAULT_DESCRIPTION);
		p.setImage(DEFAULT_IMAGE);
		p.setUnitPrice(DEFAULT_UNIT_PRICE);
		p.setCreatedDate(DEFAULT_CREATED_DATE);
		return p;
	}
	
}
