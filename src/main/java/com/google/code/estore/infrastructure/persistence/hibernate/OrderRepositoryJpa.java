package com.google.code.estore.infrastructure.persistence.hibernate;

import org.springframework.data.repository.CrudRepository;

import com.google.code.estore.domain.model.shopping.Order;

public interface OrderRepositoryJpa  extends CrudRepository<Order, Long>{
	
	
	
}
