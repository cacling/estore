package com.google.code.estore.domain.model.customer;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.google.code.estore.domain.shared.Entity;

@javax.persistence.Entity
@Table(name="ACCOUNTS")
public class Account  implements Entity<Address> {
	
	private String cardNumber;
	
	private String cardExpireDate;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	public Long getId() {
		return id;
	}
	
	@ManyToOne
	private Customer customer;

	public void setId(Long id) {
		this.id = id;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardExpireDate() {
		return cardExpireDate;
	}

	public void setCardExpireDate(String cardExpireDate) {
		this.cardExpireDate = cardExpireDate;
	}

	public boolean sameIdentityAs(Address other) {
		// TODO Auto-generated method stub
		return false;
	}


}
