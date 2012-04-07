package com.google.code.estore.application.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.google.code.estore.domain.model.product.ProductFactory;

public class SampleDataGenerator implements ServletContextListener {

	public void contextInitialized(ServletContextEvent event) {
		loadSampleData();
	}

	public void loadSampleData() {
		System.out.println("loadSampleData.......");
		ProductFactory.createProduct("Canon EOS 600D","EF-S 18-55mm f/3.5-5.6 IS II","EOS600D.jpg",5180,4799,"20120101").save();
		ProductFactory.createProduct("Canon EOS 5D Mark II","EF 24-105mm f/4L IS USM","EOS5DMarkII.jpg",21500,19499,"20120102").save();
		ProductFactory.createProduct("Canon EOS 550D","EF-S 18-135mm f/3.5-5.6 IS","EOS550D.jpg",6630,5988,"20120103").save();
		ProductFactory.createProduct("Nikon D3100","AF-S DX 18-55mm f/3.5-5.6G VR","NikonD3100.jpg",4300,3599,"20120104").save();
		ProductFactory.createProduct("Nikon D5100","AF-S DX 18-55mm f/3.5-5.6G VR","NikonD5100.jpg",5500,4799,"20120105").save();
		
		ProductFactory.createProduct("ASUS K43EI245SA-SL","i5-2450M 4G 500G HD6","ASUSK43EI245SA-SL.jpg",5300,4299,"20120101").save();
		ProductFactory.createProduct("Acer AS4749-32352G50","i3-2350M 2G 500G ","AcerAS4749-32352G50.jpg",4500,3099,"20120102").save();
		ProductFactory.createProduct("Lenovo Z470K","i3-2350M 4G 500G","LenovoZ470K.jpg",4200,3999,"20120103").save();
		ProductFactory.createProduct("SONY VPCEG38EC/W","i5-2450M 2G 640G","SONYVPCEG38EC.jpg",5100,4899,"20120104").save();
		ProductFactory.createProduct("TOSHIBA L730-T21N","i3-2330M 2G 500G","TOSHIBAL730-T21N.jpg",4000,3499,"20120105").save();
		
		ProductFactory.createProduct("Canon Power Shot G1 X","1430万像素 3.0可旋转液晶屏 4倍","PowerShotG1X.jpg",5400,4999,"20120101").save();
		ProductFactory.createProduct("Canon IXUS115 HS","1210万像素 3.0寸液晶屏 4倍光学","IXUS115HS.jpg",2200,1149,"20120101").save();
		ProductFactory.createProduct("SAMSUNG PL210","1400万像素 3寸屏 10倍光变 27m","SAMSUNGPL210.jpg",1200,979,"20120102").save();
		ProductFactory.createProduct("Panasonic GF2CGK","14mm/F2.5","PanasonicGF2CGK.jpg",3200,3099,"20120103").save();
		ProductFactory.createProduct("PENTAX RZ18","18倍光变25mm","PENTAXRZ18.jpg",2000,1599,"20120104").save();
	}

	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
	}
}
