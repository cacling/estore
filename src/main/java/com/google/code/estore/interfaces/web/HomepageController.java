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
	
	
	@Autowired
	private ProductManageService productManageService;
	
	@RequestMapping("/index")  
    public String displayArea(PrintWriter out,Map model){  
		List<Product> newProducts = productManageService.get4LatestProducts();
	    model.put("newProducts", DisplayAreaDTOAssembler.toDisplayItemDTOs(newProducts));  
	    
	    List<Product> bestSellingProducts = productManageService.get4BestSellingProducts();
	    model.put("bestSellingProducts", DisplayAreaDTOAssembler.toDisplayItemDTOs(bestSellingProducts));
	    
	    
	    List<Product> bestPriceProducts = productManageService.get4BestPriceProducts();
	    model.put("bestPriceProducts", DisplayAreaDTOAssembler.toDisplayItemDTOs(bestPriceProducts));
	    
	    List<Product> recommendProducts = productManageService.get10RecommendProducts();
	    model.put("recommendProducts", DisplayAreaDTOAssembler.toDisplayItemDTOs(recommendProducts));
	    
        return "index";  
    }  
	
	@RequestMapping("/start")  
    public String start(PrintWriter out,Map model){  
		out.println("hello ");  
	    model.put("message", Product.findAll());  
        return "start";  
    }  
}