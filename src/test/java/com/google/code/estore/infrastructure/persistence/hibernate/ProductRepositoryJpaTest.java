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

import com.google.code.estore.domain.model.product.Product;
import com.google.code.estore.domain.model.product.ProductFactory;


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
		productRepository.save(ProductFactory.createProduct("prod1",1.0));
		productRepository.save(ProductFactory.createProduct("prod2",1.0));
		productRepository.save(ProductFactory.createProduct("prod3",1.0));
		Product product = productRepository.findByName("prod2");
		Assert.assertNotNull(product.getId());
	}
	
	@Test
	public void findTopXLastCreatedProducts() {
		productRepository.save(ProductFactory.createProduct("prod1","","",1,1,"20120101"));
		productRepository.save(ProductFactory.createProduct("prod2","","",1,1,"20120102"));
		productRepository.save(ProductFactory.createProduct("prod3","","",1,1,"20120103"));
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

}
