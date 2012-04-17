package com.google.code.estore.application.security;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.code.estore.application.CustomerManageService;

public class EStoreRealm extends AuthorizingRealm {
	
	@Autowired
	CustomerManageService customerManageService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection prin) {
		// TODO Auto-generated method stub
		System.out.println("doGetAuthorizationInfo");
		String username = prin.asList().get(0).toString();

		if (username.equals("wei")) {
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			info.addStringPermission("view:member");
			return info;
		}
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authc) throws AuthenticationException {
		UsernamePasswordToken user = (UsernamePasswordToken) authc;
		String username = user.getUsername();
		String password = String.copyValueOf(user.getPassword());
		if (customerManageService.customerExists(username, password)) {
			SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(
					username, password, getName());
			return info;
		}
		return null;

	}

}
