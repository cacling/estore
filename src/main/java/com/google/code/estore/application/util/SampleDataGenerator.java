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
		Product p1 = ProductFactory.getProductBuilder().withName("Canon EOS 600D").withDescription("EF-S 18-55mm f/3.5-5.6 IS II")
				.withImage("EOS600D.jpg").withUnitPrice(5180).withSalePrice(4799).withCreatedDate("20120101").build().save();
		Product p2 = ProductFactory.getProductBuilder().withName("Canon EOS 5D Mark II").withDescription("EF 24-105mm f/4L IS USM")
				.withImage("EOS5DMarkII.jpg").withUnitPrice(21500).withSalePrice(19499).withCreatedDate("20120102").build().save();
		Product p3 = ProductFactory.getProductBuilder().withName("Canon EOS 550D").withDescription("EF-S 18-135mm f/3.5-5.6 IS")
				.withImage("EOS550D.jpg").withUnitPrice(6630).withSalePrice(5988).withCreatedDate("20120103").build().save();
		Product p4 = ProductFactory.getProductBuilder().withName("Nikon D3100").withDescription("AF-S DX 18-55mm f/3.5-5.6G VR")
				.withImage("NikonD3100.jpg").withUnitPrice(4300).withSalePrice(3599).withCreatedDate("20120104").build().save();
		Product p5 = ProductFactory.getProductBuilder().withName("Nikon D5100").withDescription("AF-S DX 18-55mm f/3.5-5.6G VR")
				.withImage("NikonD5100.jpg").withUnitPrice(5500).withSalePrice(4799).withCreatedDate("20120105").build().save();
		
		Product p6 = ProductFactory.getProductBuilder().withName("ASUS K43EI2").withDescription("i5-2450M 4G 500G HD6")
				.withImage("ASUSK43EI245SA-SL.jpg").withUnitPrice(5300).withSalePrice(4299).withCreatedDate("20120101").build().save();
		Product p7 = ProductFactory.getProductBuilder().withName("Acer AS4749").withDescription("i3-2350M 2G 500G ")
				.withImage("AcerAS4749-32352G50.jpg").withUnitPrice(4500).withSalePrice(3099).withCreatedDate("20120102").build().save();
		Product p8 = ProductFactory.getProductBuilder().withName("Lenovo Z470K").withDescription("i3-2350M 4G 500G")
				.withImage("LenovoZ470K.jpg").withUnitPrice(4200).withSalePrice(3999).withCreatedDate("20120103").build().save();
		Product p9 = ProductFactory.getProductBuilder().withName("SONY VPCEG38EC/W").withDescription("i5-2450M 2G 640G")
				.withImage("SONYVPCEG38EC.jpg").withUnitPrice(5100).withSalePrice(4899).withCreatedDate("20120104").build().save();
		Product p10 = ProductFactory.getProductBuilder().withName("TOSHIBA L730-T21N").withDescription("i3-2330M 2G 500G")
				.withImage("TOSHIBAL730-T21N.jpg").withUnitPrice(4000).withSalePrice(3499).withCreatedDate("20120105").build().save();
		
		Product p11 = ProductFactory.getProductBuilder().withName("Canon G1 X").withDescription("1430万像素 3.0可旋转液晶屏 4倍")
				.withImage("PowerShotG1X.jpg").withUnitPrice(5400).withSalePrice(4999).withCreatedDate("20120101").build().save();
		Product p12 = ProductFactory.getProductBuilder().withName("Canon IXUS115 HS").withDescription("1210万像素 3.0寸液晶屏 4倍光学")
				.withImage("IXUS115HS.jpg").withUnitPrice(2200).withSalePrice(1149).withCreatedDate("20120101").build().save();
		Product p13 = ProductFactory.getProductBuilder().withName("SAMSUNG PL210").withDescription("1400万像素 3寸屏 10倍光变 27m")
				.withImage("SAMSUNGPL210.jpg").withUnitPrice(1200).withSalePrice(979).withCreatedDate("20120102").build().save();
		Product p14 = ProductFactory.getProductBuilder().withName("Panasonic GF2CGK").withDescription("14mm/F2.5")
				.withImage("PanasonicGF2CGK.jpg").withUnitPrice(3200).withSalePrice(3099).withCreatedDate("20120103").build().save();
		Product p15 = ProductFactory.getProductBuilder().withName("PENTAX RZ18").withDescription("18倍光变25mm")
				.withImage("PENTAXRZ18.jpg").withUnitPrice(2000).withSalePrice(1599).withCreatedDate("20120104").build().save();
	
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
				.withOderItem(p13, 1).withOderItem(p15, 1).withOderItem(p14, 1).build();
		CustomerFactory.getCustomerBuilder(c2)
				.withAddress("Guangzhou", "Beijing Road #39").withAddress("Guangzhou", "Beijing Road #40")
				.withAccount("123456", "07/15").withAccount("234567", "08/16")
				.withOrder(o3).withOrder(o4).build().save();
		
		
		
	}

	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
	}
}
