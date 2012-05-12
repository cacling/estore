package com.google.code.estore.domain.model.customer;

import org.springframework.util.Assert;

import com.google.code.estore.domain.model.product.Product;
import com.google.code.estore.domain.model.shopping.Cart;
import com.google.code.estore.domain.model.shopping.CartItem;
import com.google.code.estore.domain.model.shopping.Order;
import com.google.code.estore.domain.shared.EntityFactory;

public class CustomerFactory implements EntityFactory{
	
	private static final String DEFAULT_NAME = "";
	
	public static Customer createCustomer(String name) {
		Customer c = getDefaultCustomer();
		c.setName(name);
		setPasswordEmailWithDefaultName(c,name);
		return c;
	}
	
	private static Customer getDefaultCustomer() {
		Customer c = new Customer();
		c.setName(DEFAULT_NAME);
		c.setCart(new Cart());
		return c;
	}
	
	public static CustomerBuilder getCustomerBuilder(){
		return  new CustomerFactory().new CustomerBuilder();
	}
	
	public static CustomerBuilder getCustomerBuilder(Customer customer){
		return  new CustomerFactory().new CustomerBuilder(customer);
	}
	
	private static void setPasswordEmailWithDefaultName(Customer customer, String name){
		if(customer.getEmail() == null){
			customer.setEmail(name + "@gmail.com");
		}
		if(customer.getPassword() == null){
			customer.setPassword(name);
		}
	}
	
	public class CustomerBuilder {
		
		private Customer customer = new Customer();
		
		public CustomerBuilder() {
			customer.setCart(new Cart());  
		}
		
		public CustomerBuilder(Customer customer) {
			this.customer = customer;
		}
		
		public CustomerBuilder withName(String name){
			customer.setName(name);
			setPasswordEmailWithDefaultName(customer, name);
			return this;
		}
		
		public CustomerBuilder withAddress(String city, String address){
			Address addr = new Address();
			addr.setCity(city);
			addr.setAddress(address);
			addr.setCustomer(customer);
			customer.addAddress(addr);
			return this;
		}
		
		public CustomerBuilder withAccount(String cardNumber,String cardExpireDate) {
			Account account = new Account();
			account.setCardNumber(cardNumber);
			account.setCardExpireDate(cardExpireDate);
			account.setCustomer(customer);
			customer.addAccount(account);
			return this;
		}
		
		public CustomerBuilder withOrder(Order order){
			order.setCustomer(customer);
			customer.addOrder(order);
			return this;
		}
		
		public CustomerBuilder withCartItem(Product product, long quantity){
			CartItem cartItem = new CartItem();
			cartItem.setProduct(product);
			cartItem.setQuantity(quantity);
			cartItem.setCart(customer.getCart());
			customer.getCart().addCartItem(cartItem);
			return this;
		}
		
		public Customer build() {
			//validate
			Assert.hasLength(customer.getName(),"customer name should not empty");
			return customer;
		}
		
	}
	
}
