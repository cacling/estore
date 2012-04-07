package com.google.code.estore.domain.model.product;

import java.text.NumberFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.google.code.estore.domain.shared.Entity;
import com.google.code.estore.domain.shared.RepositoryFactory;

@Component
@javax.persistence.Entity
@Table(name="PRODUCTS") 
public class Product implements Entity<Product>{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(unique = true)
	private String name;

	private String description;
	
	private String image;
	
	private Double unitPrice;
	
	private Double salePrice;
	
	private Date createdDate;
	
	
	public Product() {
	}

	public Product(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public boolean sameIdentityAs(Product other) {
		// TODO Auto-generated method stub
		return false;
	}
	
	//Business Methods ================================================
	public Double getSalePrice() {
		if(salePrice == null){
			salePrice = unitPrice;
		}
		return salePrice;
	}
	
	public String getDiscount() {
		if(salePrice == unitPrice){
			return "";
		}else{
			Double d = (unitPrice - salePrice)/salePrice;
			return NumberFormat.getPercentInstance().format(d); 
		}
		
	}
	
	public void save() {
		RepositoryFactory.getProductRepository().save(this);
	}

	public static Product findByName(String name) {
		return RepositoryFactory.getProductRepository().findByName(name);
	}
	
	public static Iterable<Product> findAll() {
		return RepositoryFactory.getProductRepository().findAll();
	}

}
