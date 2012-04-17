package com.google.code.estore.infrastructure.persistence.hibernate;

import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.google.code.estore.domain.model.customer.Account;
import com.google.code.estore.domain.model.customer.Address;
import com.google.code.estore.domain.model.customer.Customer;
import com.google.code.estore.domain.model.customer.CustomerFactory;
import com.google.code.estore.domain.model.product.Product;
import com.google.code.estore.domain.model.product.ProductFactory;
import com.google.code.estore.domain.model.shopping.Order;
import com.google.code.estore.domain.model.shopping.OrderFactory;
import com.google.code.estore.domain.shared.util.DateUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:/estore-infrastructure-persistence.xml",
		"classpath:/applicationContext-test.xml" })
@TransactionConfiguration
@Transactional
public class CustomerRepositoryJpaTest  {
	
	@Autowired
	protected CustomerRepositoryJpa customerRepositoryJpa;

	@Before
	public void prepareData() {
	}
	
	@Test 
	public void findByName() {
		customerRepositoryJpa.save(CustomerFactory.createCustomer("customer1"));
		customerRepositoryJpa.save(CustomerFactory.createCustomer("customer2"));
		customerRepositoryJpa.save(CustomerFactory.createCustomer("customer3"));
		Customer customer = customerRepositoryJpa.findByName("customer2");
		Assert.assertNotNull(customer.getId());
		Assert.assertEquals("customer2", customer.getName());
	}
	
	@Test 
	public void findByUsernameAndPassword() {
		customerRepositoryJpa.save(CustomerFactory.createCustomer("c1"));
		Customer customer = customerRepositoryJpa.findByNameAndPassword("c1", "c1");
		Assert.assertNotNull(customer.getId());
		Assert.assertEquals("c1", customer.getName());
		
		customer = customerRepositoryJpa.findByNameAndPassword("c1", "c2");
		Assert.assertNull(customer);
		
	}
	
	@Test
	public void saveWithOrders(){
		Product p1 = ProductFactory.createProduct("prod1",1.0);
		Product p2 = ProductFactory.createProduct("prod2",2.0);
		
		Order o1 = OrderFactory.getOrderBuilder().withOrderDate("20120101").withTotalMoney(1000)
				.withOderItem(p1, 10).withOderItem(p2, 20).build();
		Order o2 = OrderFactory.getOrderBuilder().withOrderDate("20120102").withTotalMoney(2000)
				.withOderItem(p1, 30).withOderItem(p2, 40).build();
		
		CustomerFactory.getCustomerBuilder().withName("abc")
		.withAddress("Guangzhou", "add1").withAddress("Shenzhen", "add2")
		.withAccount("123456", "07/15").withAccount("234567", "08/15").withAccount("345678", "09/15")
		.withOrder(o1).withOrder(o2).build().save();
		
		Customer customerFromDB = customerRepositoryJpa.findByName("abc");
		
		List<Address> addresses = customerFromDB.getAddresses();
		Assert.assertEquals(2, addresses.size());
		Assert.assertEquals("Guangzhou",addresses.get(0).getCity());
		
		List<Account> accounts = customerFromDB.getAccounts();
		Assert.assertEquals(3, accounts.size());
		Assert.assertEquals("123456",accounts.get(0).getCardNumber());
		
		List<Order> orders = customerFromDB.getOrders();
		Assert.assertEquals(2, orders.size());
		Order orderFromDB = orders.get(0);
		Assert.assertEquals("20120101",DateUtil.format(orderFromDB.getOrderDate()));
		Assert.assertEquals(2,orderFromDB.getOrderItems().size());
		
		Assert.assertEquals("prod1",orderFromDB.getOrderItems().get(0).getProduct().getName());
		
	}
	
	

}
