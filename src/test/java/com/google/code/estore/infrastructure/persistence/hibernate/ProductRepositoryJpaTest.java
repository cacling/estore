package com.google.code.estore.infrastructure.persistence.hibernate;

import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.google.code.estore.domain.model.customer.CustomerFactory;
import com.google.code.estore.domain.model.product.Product;
import com.google.code.estore.domain.model.product.ProductFactory;
import com.google.code.estore.domain.model.shopping.Order;
import com.google.code.estore.domain.model.shopping.OrderFactory;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:/estore-infrastructure-persistence.xml",
		"classpath:/applicationContext-test.xml" })
@Transactional
public class ProductRepositoryJpaTest {
	
	@Autowired
	protected ProductRepositoryJpa productRepository;

	@Before
	public void prepareData() {
	}
	
	@Test
	public void findByName() {
		ProductFactory.createProduct("prod1",1.0).save();
		ProductFactory.createProduct("prod2",1.0).save();
		ProductFactory.createProduct("prod3",1.0).save();
		Product product = productRepository.findByName("prod2");
		Assert.assertNotNull(product.getId());
	}
	
	@Test
	public void findTopXLastCreatedProducts() {
		ProductFactory.getProductBuilder().withName("prod1").withUnitPrice(1).withCreatedDate("20120101").build().save();
		ProductFactory.getProductBuilder().withName("prod2").withUnitPrice(1).withCreatedDate("20120102").build().save();
		ProductFactory.getProductBuilder().withName("prod3").withUnitPrice(1).withCreatedDate("20120103").build().save();
		//get top 2
		List<Product> products = productRepository.findTopXLastCreatedProducts(2);
		Assert.assertEquals(2,products.size());
		Assert.assertEquals("prod1",products.get(0).getName());
		Assert.assertEquals("prod2",products.get(1).getName());
		//get top 1
		products = productRepository.findTopXLastCreatedProducts(1);
		Assert.assertEquals(1,products.size());
		Assert.assertEquals("prod1",products.get(0).getName());
	}
	
	@Test
	public void findTopXOrderedProducts() {
		Product p1 = ProductFactory.createProduct("p1",1.0).save();
		Product p2 = ProductFactory.createProduct("p2",2.0).save();
		Product p3 = ProductFactory.createProduct("p3",2.0).save();
		
		Order o1 = OrderFactory.getOrderBuilder().withOrderDate("20120101").withTotalMoney(1000)
				.withOderItem(p1, 1).withOderItem(p2, 1).build();
		Order o2 = OrderFactory.getOrderBuilder().withOrderDate("20120102").withTotalMoney(2000)
				.withOderItem(p1, 1).withOderItem(p3, 3).build();
		CustomerFactory.getCustomerBuilder().withName("c1")
				.withAddress("Guangzhou", "Jiangnanxi Road #39").withAddress("Guangzhou", "Jiangnanxi Road #40")
				.withAccount("123456", "07/15").withAccount("234567", "08/16")
				.withOrder(o1).withOrder(o2).build().save();
		
		List<Product> products = productRepository.findTopXOrderedProducts(2);
		Assert.assertEquals(2,products.size());
		Assert.assertEquals("p3",products.get(0).getName());
		Assert.assertEquals("p1",products.get(1).getName());
	}
	
	@Test
	public void findTopXDiscountMostProducts(){
		ProductFactory.getProductBuilder().withName("p1").withUnitPrice(2000).withSalePrice(1000).withCreatedDate("20120101").build().save();
		ProductFactory.getProductBuilder().withName("p2").withUnitPrice(2000).withSalePrice(2000).withCreatedDate("20120102").build().save();
		ProductFactory.getProductBuilder().withName("p3").withUnitPrice(5000).withSalePrice(1000).withCreatedDate("20120103").build().save();

		
		List<Product> products = productRepository.findTopXDiscountMostProducts(2);
		Assert.assertEquals(2,products.size());
		Assert.assertEquals("p3",products.get(0).getName());
		Assert.assertEquals("p1",products.get(1).getName());
		
	}

}
