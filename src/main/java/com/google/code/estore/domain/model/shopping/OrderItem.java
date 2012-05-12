package com.google.code.estore.domain.model.shopping;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.google.code.estore.domain.model.product.Product;
import com.google.code.estore.domain.shared.ValueObject;

@javax.persistence.Entity
@Table(name="ORDERITEMS") 
public class OrderItem  implements ValueObject<OrderItem> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	private Product product;
	
	private Long quantity;
	
	@ManyToOne
	private Order order;
	
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public boolean sameValueAs(OrderItem other) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}
