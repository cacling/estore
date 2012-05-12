package com.google.code.estore.domain.model.customer;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.google.code.estore.domain.shared.Entity;

@javax.persistence.Entity
@Table(name="ADDRESSES")
public class Address implements Entity<Address> {
	
	private String city;
	
	private String address;
	
	@ManyToOne
	private Customer customer;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean sameIdentityAs(Address other) {
		// TODO Auto-generated method stub
		return false;
	}

}
