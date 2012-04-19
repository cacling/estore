package com.google.code.estore.interfaces.web;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.code.estore.application.CartManageService;
import com.google.code.estore.application.CustomerManageService;
import com.google.code.estore.application.ProductManageService;
import com.google.code.estore.domain.model.product.Product;
import com.google.code.estore.infrastructure.util.CookieUtil;
import com.google.code.estore.interfaces.facade.assembler.CartAssembler;
import com.google.code.estore.interfaces.facade.assembler.DisplayAreaDTOAssembler;
import com.google.code.estore.interfaces.facade.dto.CartItemDTO;

@Controller  
public class HomepageController {
	
	
	@Autowired
	private ProductManageService productManageService;
	
	@Autowired
	private CustomerManageService customerManageService;
	
	@Autowired
	private CartManageService cartManageService;
	
	@RequestMapping(value="/addToCart",method=RequestMethod.GET) 
	public ModelMap addToCart(HttpServletRequest request, HttpServletResponse response){
		ModelMap map = new ModelMap();
		String prodId = request.getParameter("prodId");
		String currentUsername = customerManageService.getLoginedCustomerUsername();
//		cartManageService.addToCart(request,  response, prodId,currentUsername);
        return map;
	}
	
	
	
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
	    
	    model.put("username", customerManageService.getLoginedCustomerUsername());
	    
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
		
		boolean logined =  customerManageService.login(username, password);
		map.addAttribute("loginStatus", logined);
		map.addAttribute("username",  customerManageService.getLoginedCustomerUsername());
		
		if(logined){
			String cartItemsJson = CookieUtil.getCookieValue(request, "cartItems");
			cartManageService.syncCartItemsWithCookie(customerManageService.getLoginedCustomer(), CartAssembler.toCartItemDTOs(cartItemsJson));
			List<CartItemDTO> cartItemDTOs  = CartAssembler.toCartItemDTOs(customerManageService.getLoginedCustomer().getCart().getCartItems());
			map.addAttribute("cartItems",CartAssembler.toCartItemsJson(cartItemDTOs));
		}
        return map;
    }  
	
	@RequestMapping("/test")  
    public String start(PrintWriter out,Map model){  
        return "test";  
    }  
}