package com.intelligentCommunity.service;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.intelligentCommunity.pojo.Account;

@Named
public class ShiroDbRealm extends AuthorizingRealm{

	@Inject
	private AccountService accountService;
	
	/**
	 * 权限认证
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		//获取当前登录的用户名
		String accountName = (String) principalCollection.fromRealm(getName()).iterator().next();
		
		Account account = accountService.findByAccountName(accountName);
		if(account != null) {
			SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
			//设置角色
			simpleAuthorizationInfo.setRoles(account.getRoleNames());
			/*//设置权限
			List<Role> roleList = account.getRoles();
			for(Role role : roleList) {
				simpleAuthorizationInfo.addStringPermissions(role.getPermissionNames());
			}*/
			return simpleAuthorizationInfo;
		}
		
		
		
		return null;
	}

	/**
	 * 登录
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
		Account account = accountService.findByAccountName(usernamePasswordToken.getUsername());
		if(account != null) {
			return new SimpleAuthenticationInfo(account.getEmail(), account.getPassword(), getName());
		}
		return null;
	}

}

