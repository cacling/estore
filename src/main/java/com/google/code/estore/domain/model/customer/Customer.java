package com.google.code.estore.domain.model.customer;

import java.util.ArrayList;
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
	
	private String password;
	
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

	public boolean sameIdentityAs(Customer other) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public String getPassword() {
		return password;
	}

	//Business Methods ================================================
	public List<Account> getAccounts() {
		if(accounts == null){
			accounts = new ArrayList<Account>();
		}
		return accounts;
	}
	
	public List<Address> getAddresses() {
		if(addresses == null){
			addresses = new ArrayList<Address>();
		}
		return addresses;
	}
	
	
	public List<Order> getOrders() {
		if(orders == null){
			orders = new ArrayList<Order>();
		}
		return orders;
	}
	
	public void addOrder(Order order) {
		if(orders == null){
			orders = new ArrayList<Order>();
		}
		this.orders.add(order);
	}
	
	public void addAccount(Account account) {
		if(accounts == null){
			accounts = new ArrayList<Account>();
		}
		this.accounts.add(account);
	}
	
	public void addAddress(Address address) {
		if(addresses == null){
			addresses = new ArrayList<Address>();
		}
		this.addresses.add(address);
	}
	
	public void setEmail(String email) {
		if(email == null){
			email = name + "@gmail.com";
		}
		this.email = email;
	}
	
	public void setPassword(String password) {
		if(password == null){
			password = name;
		}
		this.password = password;
	}
	
	public Customer save() {
		return RepositoryFactory.getCustomerRepository().save(this);
	}

	public static Customer findByName(String name) {
		return RepositoryFactory.getCustomerRepository().findByName(name);
	}
	
}
