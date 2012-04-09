package com.google.code.estore.application.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.google.code.estore.domain.model.customer.Customer;
import com.google.code.estore.domain.model.customer.CustomerFactory;
import com.google.code.estore.domain.model.product.Product;
import com.google.code.estore.domain.model.product.ProductFactory;
import com.google.code.estore.domain.model.shopping.Order;
import com.google.code.estore.domain.model.shopping.OrderFactory;

public class SampleDataGenerator implements ServletContextListener {

	public void contextInitialized(ServletContextEvent event) {
		loadSampleData();
	}

	public void loadSampleData() {
		System.out.println("load product data .......");
		Product p1 = ProductFactory.createProduct("Canon EOS 600D","EF-S 18-55mm f/3.5-5.6 IS II","EOS600D.jpg",5180,4799,"20120101").save();
		Product p2 = ProductFactory.createProduct("Canon EOS 5D Mark II","EF 24-105mm f/4L IS USM","EOS5DMarkII.jpg",21500,19499,"20120102").save();
		Product p3 = ProductFactory.createProduct("Canon EOS 550D","EF-S 18-135mm f/3.5-5.6 IS","EOS550D.jpg",6630,5988,"20120103").save();
		Product p4 = ProductFactory.createProduct("Nikon D3100","AF-S DX 18-55mm f/3.5-5.6G VR","NikonD3100.jpg",4300,3599,"20120104").save();
		Product p5 = ProductFactory.createProduct("Nikon D5100","AF-S DX 18-55mm f/3.5-5.6G VR","NikonD5100.jpg",5500,4799,"20120105").save();
		
		Product p6 = ProductFactory.createProduct("ASUS K43EI2","i5-2450M 4G 500G HD6","ASUSK43EI245SA-SL.jpg",5300,4299,"20120101").save();
		Product p7 = ProductFactory.createProduct("Acer AS4749","i3-2350M 2G 500G ","AcerAS4749-32352G50.jpg",4500,3099,"20120102").save();
		Product p8 = ProductFactory.createProduct("Lenovo Z470K","i3-2350M 4G 500G","LenovoZ470K.jpg",4200,3999,"20120103").save();
		Product p9 = ProductFactory.createProduct("SONY VPCEG38EC/W","i5-2450M 2G 640G","SONYVPCEG38EC.jpg",5100,4899,"20120104").save();
		Product p10 = ProductFactory.createProduct("TOSHIBA L730-T21N","i3-2330M 2G 500G","TOSHIBAL730-T21N.jpg",4000,3499,"20120105").save();
		
		Product p11 = ProductFactory.createProduct("Canon G1 X","1430万像素 3.0可旋转液晶屏 4倍","PowerShotG1X.jpg",5400,4999,"20120101").save();
		Product p12 = ProductFactory.createProduct("Canon IXUS115 HS","1210万像素 3.0寸液晶屏 4倍光学","IXUS115HS.jpg",2200,1149,"20120101").save();
		Product p13 = ProductFactory.createProduct("SAMSUNG PL210","1400万像素 3寸屏 10倍光变 27m","SAMSUNGPL210.jpg",1200,979,"20120102").save();
		Product p14 = ProductFactory.createProduct("Panasonic GF2CGK","14mm/F2.5","PanasonicGF2CGK.jpg",3200,3099,"20120103").save();
		Product p15 = ProductFactory.createProduct("PENTAX RZ18","18倍光变25mm","PENTAXRZ18.jpg",2000,1599,"20120104").save();
	
		System.out.println("load customer data .......");
		Customer c1 = CustomerFactory.createCustomer("Emily").save();
		Customer c2 = CustomerFactory.createCustomer("David").save();
		CustomerFactory.createCustomer("James").save();
		CustomerFactory.createCustomer("William").save();
		CustomerFactory.createCustomer("Ava").save();
		CustomerFactory.createCustomer("Lily").save();
		CustomerFactory.createCustomer("Matthew").save();
		CustomerFactory.createCustomer("Ryan").save();
		CustomerFactory.createCustomer("Mia").save();
		CustomerFactory.createCustomer("Isabella").save();
		
		Order o1 = OrderFactory.getOrderBuilder().withOrderDate("20120101").withTotalMoney(1000)
				.withOderItem(p10, 1).withOderItem(p7, 2).build();
		Order o2 = OrderFactory.getOrderBuilder().withOrderDate("20120102").withTotalMoney(2000)
				.withOderItem(p8, 3).withOderItem(p9, 4).build();
		CustomerFactory.getCustomerBuilder(c1)
				.withAddress("Guangzhou", "Jiangnanxi Road #39").withAddress("Guangzhou", "Jiangnanxi Road #40")
				.withAccount("123456", "07/15").withAccount("234567", "08/16")
				.withOrder(o1).withOrder(o2).build().save();
		
		Order o3 = OrderFactory.getOrderBuilder().withOrderDate("20120103").withTotalMoney(1000)
				.withOderItem(p11, 1).withOderItem(p12, 1).build();
		Order o4 = OrderFactory.getOrderBuilder().withOrderDate("20120104").withTotalMoney(2000)
				.withOderItem(p13, 1).withOderItem(p15, 1).build();
		CustomerFactory.getCustomerBuilder(c2)
				.withAddress("Guangzhou", "Beijing Road #39").withAddress("Guangzhou", "Beijing Road #40")
				.withAccount("123456", "07/15").withAccount("234567", "08/16")
				.withOrder(o3).withOrder(o4).build().save();
		
		
		
	}

	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
	}
}
