package com.google.code.estore.interfaces.web;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.code.estore.application.CustomerManageService;
import com.google.code.estore.application.ProductManageService;
import com.google.code.estore.domain.model.product.Product;
import com.google.code.estore.interfaces.facade.assembler.DisplayAreaDTOAssembler;

@Controller  
public class HomepageController {
	
	
	@Autowired
	private ProductManageService productManageService;
	
	@Autowired
	private CustomerManageService customerManageService;
	
	@RequestMapping(value="/index",method=RequestMethod.GET)  
    public String displayArea(PrintWriter out,Map model){
		
		
		List<Product> newProducts = productManageService.get4LatestProducts();
	    model.put("newProducts", DisplayAreaDTOAssembler.toDisplayItemDTOs(newProducts));  
	    
	    List<Product> bestSellingProducts = productManageService.get4BestSellingProducts();
	    model.put("bestSellingProducts", DisplayAreaDTOAssembler.toDisplayItemDTOs(bestSellingProducts));
	    
	    
	    List<Product> bestPriceProducts = productManageService.get4BestPriceProducts();
	    model.put("bestPriceProducts", DisplayAreaDTOAssembler.toDisplayItemDTOs(bestPriceProducts));
	    
	    List<Product> recommendProducts = productManageService.get10RecommendProducts();
	    model.put("recommendProducts", DisplayAreaDTOAssembler.toDisplayItemDTOs(recommendProducts));
	    
	    model.put("username", customerManageService.getLoginedUsername());
	    
        return "index";  
    }  
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)  
	public ModelMap doLogout(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelMap map = new ModelMap();
		map.addAttribute("logoutStatus",  customerManageService.logout());
        return map;
    }  
	
	
	@RequestMapping(value="/login",method=RequestMethod.POST)  
	public ModelMap doLogin(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		ModelMap map = new ModelMap();
		map.addAttribute("loginStatus",  customerManageService.login(username, password));
		map.addAttribute("username",  customerManageService.getLoginedUsername());
        return map;
    }  
	
	@RequestMapping("/test")  
    public String start(PrintWriter out,Map model){  
        return "test";  
    }  
}