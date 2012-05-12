package com.google.code.estore.domain.model.shopping;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.google.code.estore.domain.model.product.Product;
import com.google.code.estore.domain.shared.Entity;

@javax.persistence.Entity
@Table(name="CARTITEMS")
public class CartItem  implements Entity<CartItem> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	private Product product;
	
	private Long quantity;
	
	@ManyToOne
	private Cart cart;
	
	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
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

	public boolean sameIdentityAs(CartItem other) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	//======================================================
	
	public void addQuantity(long extraQuantity) {
		quantity = quantity + extraQuantity;
	}  
	
	
}
