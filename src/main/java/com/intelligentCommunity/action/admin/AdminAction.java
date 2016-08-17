package com.intelligentCommunity.action.admin;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.intelligentCommunity.action.BaseAction;
import com.intelligentCommunity.pojo.Account;
import com.intelligentCommunity.pojo.Role;
import com.intelligentCommunity.service.AccountService;
import com.intelligentCommunity.service.RoleService;
import com.intelligentCommunity.util.PasswordUtil;

@Controller
public class AdminAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	
	@Resource
	private AccountService accountService;
	@Resource
	private RoleService roleService;
	
	private Account account;
	private Account user;
	private String flag;
	private List<Account> list;
	private int accountId;
	private Long roleId;
	private List<Role> roleList;
	private String email;
	private String oldP;
	private Integer code;
	
	
	
	@Action(value="setting")
	public String settingForm(){
		user = (Account) getSession().get("user"); 
		if (user.isSex()) {
			flag = "1";
		} else {
			flag = "0";
		}
		return SUCCESS;
	}
	
	

	@Action(value="saveAccount",results={
			@Result(name="success",type="redirectAction",params={"actionName","setting","namespace","/admin"}),
			@Result(name="error",type="redirectAction",params={"actionName","login","namespace","/","code","${code}"})
			})
	public String setting(){
		if (flag.equals("1")) {
			user.setSex(true);
		}else {
			user.setSex(false);
		}
		String password = user.getPassword().trim();
		if (StringUtils.isNotBlank(password)) {
			user.setPassword(PasswordUtil.mixSaltPassword(user.getEmail(), password));
		}
		accountService.saveOrUpdate(user);
		if (!oldP.equals(user.getPassword())) {
			SecurityUtils.getSubject().logout();
			code = 1000;
			return ERROR;
		}
		return SUCCESS;
	}

	
	@Action(value="addAccount")
	public String addAccountForm(){
		roleList = roleService.findAll();
		return SUCCESS;
	}
	
	@Action(value="add",results={
			@Result(name="success",type="redirectAction",params={"actionName","listAccount","namespace","/admin"})})
	public String addAccount(){
		Role role = roleService.findRoleById(roleId);
		account.setRole(role);
		accountService.saveOrUpdate(account);
		return SUCCESS;
	}
	
	
	@Action(value="listAccount")
	public String listAll(){
		list = accountService.findAllAccount();
		return SUCCESS;
	}
	
	@Action(value="updateAccountForm")
	public String updateAccountForm(){
		account = accountService.findAccountById(accountId);
		return SUCCESS;
	}
	
	@Action(value="updateAccount",results={
			@Result(name="success",type="redirectAction",params={"actionName","listAccount","namespace","/admin"})})
	public String updateAccount(){
		Role role = account.getRole();
		account.setRole(role);
		accountService.saveOrUpdate(account);
		return SUCCESS;
	}
	
	
	@Action(value="delAccount",results={
			@Result(name="success",type="redirectAction",params={"actionName","listAccount","namespace","/admin"})})
	public String delAccount(){
		accountService.delAccountById(accountId);
		return SUCCESS;
	}
	
	@Action(value="validateEmail")
	public String validateEmail() throws IOException{
		Account account = accountService.findAccountByEmail(email);
		boolean result = (account == null);
		System.err.println(result);
		renderText(result);
		return NONE;
	}
	
	
	//get and set
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public List<Account> getList() {
		return list;
	}

	public void setList(List<Account> list) {
		this.list = list;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	
	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Account getUser() {
		return user;
	}

	public void setUser(Account user) {
		this.user = user;
	}
	
	public String getOldP() {
		return oldP;
	}

	public void setOldP(String oldP) {
		this.oldP = oldP;
	}



	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
	

}

