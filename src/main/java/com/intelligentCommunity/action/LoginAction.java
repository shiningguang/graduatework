package com.intelligentCommunity.action;

import javax.inject.Inject;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.intelligentCommunity.pojo.Account;
import com.intelligentCommunity.service.AccountService;
import com.intelligentCommunity.util.PasswordUtil;

@Controller
public class LoginAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Inject
	private AccountService accountService;
	private String accountName;
	private String password;
	private Integer code;
	private Account account;
	private Account user;
	

	@Action("login")
	public String loginForm() {
		return SUCCESS;
	}

	@Action(value="save",results={
			@Result(name="success",type="redirectAction",params={"actionName","home"}),
			@Result(name="error",type="redirectAction",params={"actionName","login","code","${code}"})
	})
	public String login() {
		user = new Account();
		user.setId(1);
		user.setAddress("748347329");
		user.setDescript("dasdas");
		user.setEmail("1212");
		
		putSession("user",user);
		
		try {
			/*SecurityUtils.getSubject().login(new UsernamePasswordToken(accountName, PasswordUtil.mixSaltPassword(accountName, password)));
			user = accountService.findByAccountName(accountName);
			putSession("user", user);*/
			return SUCCESS;
		} catch (Exception e) {
			code = 1001;
			return SUCCESS;
		}
		
		
		/*account = accountService.findAccountByEmailAndPassword(accountName, password);
		if (account != null) {
			putSession("account", account);
			return SUCCESS;
		} else {
			code = 1001;
			return ERROR;
		}*/
		
	}
	
	@Action(value="home")
	public String index() {
		user = (Account) getSession().get("user"); 
		return SUCCESS;
	}
	
	@Action(value="logout",results={
			@Result(name="success",type="redirectAction",params={"actionName","login"})
	})
	public String logout(){
		//SecurityUtils.getSubject().logout();
		return SUCCESS;
	}
	
	//get and set

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	public Account getUser() {
		return user;
	}

	public void setUser(Account user) {
		this.user = user;
	}
}

