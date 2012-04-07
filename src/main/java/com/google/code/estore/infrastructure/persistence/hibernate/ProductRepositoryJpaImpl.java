package com.google.code.estore.infrastructure.persistence.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.google.code.estore.domain.model.product.Product;

public class ProductRepositoryJpaImpl implements ProductRepositoryJpaCustom{
	
	@PersistenceContext
	private EntityManager em;
	
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
	
	public List<Product> myCustomBatchOperation(String xxxx) {
		em.flush();
		return null;
	}
	
	public List<Product> findTopXLastCreatedProducts(int x) {
		Query query = em.createQuery("from Product p order by createdDate");
		query.setMaxResults(x);
		return query.getResultList();
	}

}
