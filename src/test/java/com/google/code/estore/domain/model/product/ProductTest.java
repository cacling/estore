package com.google.code.estore.domain.model.product;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:/estore-infrastructure-persistence.xml",
		"classpath:/estore-domain.xml",
		"classpath:/applicationContext-test.xml" })
@Transactional
public class ProductTest {
	
	@Before
	public void prepareData() {
	}
	
	@Test
	public void findByName() {
		ProductFactory.createProduct("prod1",1.0).save();
		ProductFactory.createProduct("prod2",1.0).save();
		ProductFactory.createProduct("prod3",1.0).save();
		Product product = Product.findByName("prod2");
		Assert.assertNotNull(product.getId());
	}

}
