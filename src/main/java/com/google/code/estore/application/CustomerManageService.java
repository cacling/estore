package com.google.code.estore.application;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.code.estore.domain.model.customer.Customer;
import com.google.code.estore.domain.shared.RepositoryFactory;

@Component
public class CustomerManageService {
	
	@Autowired
	CartManageService cartManageService;
	
	public Customer getLoginedCustomer() {
		String loginedUsername = getLoginedCustomerUsername();
		return Customer.findByName(loginedUsername);
	}
	
	public boolean isLogined() {
		Subject currentUser = SecurityUtils.getSubject(); 
        return currentUser.isAuthenticated(); 
	}
	
	public boolean login(String username, String password) {
		boolean logined = true;
		Subject currentUser = SecurityUtils.getSubject(); 
        if(!currentUser.isAuthenticated()){  
            UsernamePasswordToken token = new UsernamePasswordToken(username,password);
			try {  
                currentUser.login(token);  
            } catch (AuthenticationException ae ) {  
            	logined = false;
            } 
        } 
        return logined;
	}
	
	public boolean logout() {
		Subject currentUser = SecurityUtils.getSubject(); 
		currentUser.logout();
		return true;
	}
	
	public String getLoginedCustomerUsername() {
		Subject currentUser = SecurityUtils.getSubject(); 
        if(currentUser.isAuthenticated()){  
        	return (String)currentUser.getPrincipal();
        }
        return null;
	}
	
	public boolean customerExists(String username, String password) {
		return null != RepositoryFactory.getCustomerRepository().findByNameAndPassword(username, password);
	}

}
