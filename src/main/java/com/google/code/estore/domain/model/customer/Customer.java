package com.google.code.estore.domain.model.customer;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.google.code.estore.domain.model.shopping.Cart;
import com.google.code.estore.domain.model.shopping.Order;
import com.google.code.estore.domain.shared.Entity;
import com.google.code.estore.domain.shared.RepositoryFactory;

@Component
@javax.persistence.Entity
@Table(name="CUSTOMERS") 
public class Customer implements Entity<Customer>{
	 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	@Column(unique = true)
	private String email;
	
	@OneToMany(mappedBy ="customer") 
	private List<Account> accounts;
	
	@OneToMany(mappedBy ="customer") 
	private List<Address> addresses;
	
	@OneToMany(mappedBy ="customer") 
	private List<Order> orders;
	
	@OneToOne
	private Cart cart;
	
	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public boolean sameIdentityAs(Customer other) {
		// TODO Auto-generated method stub
		return false;
	}

	
	//Business Methods ================================================
	public void save() {
		RepositoryFactory.getCustomerRepository().save(this);
	}

	public static Customer findByName(String name) {
		return RepositoryFactory.getCustomerRepository().findByName(name);
	}
	
}
