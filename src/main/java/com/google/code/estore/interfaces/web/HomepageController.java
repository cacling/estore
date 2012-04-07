package com.google.code.estore.interfaces.web;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.code.estore.application.ProductManageService;
import com.google.code.estore.domain.model.product.Product;
import com.google.code.estore.domain.shared.RepositoryFactory;
import com.google.code.estore.interfaces.facade.assembler.DisplayAreaDTOAssembler;
import com.google.code.estore.interfaces.facade.dto.DisplayItemDTO;

@Controller  
public class HomepageController {
	
	
	//big discount
	
	//hot sales
	
	//new product
	
	//guess what you like
	
	@Autowired
	private ProductManageService productManageService;
	
	@RequestMapping("/displayArea")  
    public String displayArea(PrintWriter out,Map model){  
		List<Product> products = productManageService.getLatest4Products();
		List<DisplayItemDTO> i = DisplayAreaDTOAssembler.toDisplayItemDTOs(products);
		System.out.println(i.get(0).getName());
		
	    model.put("displayItems", DisplayAreaDTOAssembler.toDisplayItemDTOs(products));  
        return "index";  
    }  
	
	@RequestMapping("/start")  
    public String start(PrintWriter out,Map model){  
		out.println("hello ");  
	    model.put("message", Product.findAll());  
        return "start";  
    }  
}