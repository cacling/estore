package com.google.code.estore.domain.model.shopping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.code.estore.infrastructure.persistence.hibernate.OrderRepositoryJpa;

@Component
public class OrderRepository {
	
	@Autowired
	private OrderRepositoryJpa orderRepositoryJpa;

	public Order save(Order order) {
		return orderRepositoryJpa.save(order);
	}
}
