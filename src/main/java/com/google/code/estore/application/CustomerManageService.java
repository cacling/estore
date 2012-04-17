package com.google.code.estore.application;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Component;

import com.google.code.estore.domain.shared.RepositoryFactory;

@Component
public class CustomerManageService {
	
	public boolean login(String username, String password) {
		boolean logined = true;
		Subject currentUser = SecurityUtils.getSubject(); 
        if(!currentUser.isAuthenticated()){  
            UsernamePasswordToken token;  
            token = new UsernamePasswordToken(username,password);
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
	
	public String getLoginedUsername() {
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
