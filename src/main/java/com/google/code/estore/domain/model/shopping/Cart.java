package com.google.code.estore.domain.model.shopping;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import com.google.code.estore.domain.shared.Entity;

@javax.persistence.Entity
@Table(name="CARTS")
public class Cart implements Entity<Cart>{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToMany(mappedBy ="cart") 
	private List<CartItem> cartItems;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public boolean sameIdentityAs(Cart other) {
		// TODO Auto-generated method stub
		return false;
	}

}
