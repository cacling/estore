package com.google.code.estore.infrastructure.persistence.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang.ArrayUtils;

import com.google.code.estore.domain.model.product.Product;
import com.google.code.estore.infrastructure.persistence.hibernate.util.JpaResultUtil;

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

	public List<Product> findTopXOrderedProducts(int x) {
		Query query = em.createQuery("select p.id from Order o, OrderItem oi, Product p where oi.product=p.id and oi.order=o.id group by p.id order by sum(oi.quantity) desc");
		query.setMaxResults(x);
		List ids = query.getResultList();
		query = em.createQuery("select p from  Product p where p.id in (:ids)");
		query.setParameter("ids",ids);
		return query.getResultList();
	}

	public List<Product> findTopXDiscountMostProducts(int x) {
		Query query = em.createQuery("from Product p order by ((p.unitPrice-p.salePrice)/p.unitPrice) desc");
		query.setMaxResults(x);
		return query.getResultList();
	}
}
