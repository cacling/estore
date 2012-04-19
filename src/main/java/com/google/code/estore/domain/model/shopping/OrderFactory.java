package com.google.code.estore.domain.model.shopping;

import java.util.Date;

import org.springframework.util.Assert;

import com.google.code.estore.domain.model.product.Product;
import com.google.code.estore.domain.shared.EntityFactory;
import com.google.code.estore.infrastructure.util.DateUtil;

public class OrderFactory implements EntityFactory {

	public static OrderBuilder getOrderBuilder() {
		return new OrderFactory().new OrderBuilder();
	}

	public class OrderBuilder {
		
		private Order order = new Order();
		
		public OrderBuilder(){
		}
		
		public OrderBuilder(Order order){
			this.order = order;
		}
		
		
		public OrderBuilder withOrderDate(String orderDate){
			Date od = DateUtil.parseDate(orderDate);
			order.setOrderDate(od);
			return this;
		}
		
		public OrderBuilder withShipDate(String shipDate){
			Date sd = DateUtil.parseDate(shipDate);
			order.setShipDate(sd);
			return this;
		}
		
		public OrderBuilder withShipAddress(String shipAddress){
			order.setShipAddress(shipAddress);
			return this;
		}
		
		public OrderBuilder withTotalMoney(double totalMoney){
			order.setTotalMoney(totalMoney);
			return this;
		}
		
		public OrderBuilder withOderItem(Product product, long quantity){
			OrderItem orderItem = new OrderItem();
			orderItem.setProduct(product);
			orderItem.setQuantity(quantity);
			orderItem.setOrder(order);
			order.addOrderItem(orderItem);
			return this;
		}
		
		public Order build(){
			//validate
			Assert.notNull(order.getOrderDate(),"order date should not empty");
			Assert.notNull(order.getTotalMoney(),"totalMoney should not empty");
			if(order.getOrderItems() != null){
				for (OrderItem orderItem : order.getOrderItems()) {
					Assert.notNull(orderItem.getProduct(),"product should not null");
				}
			}
			return order;
		}

	}

}
