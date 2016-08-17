package com.intelligentCommunity.action.fix;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.intelligentCommunity.action.BaseAction;
import com.intelligentCommunity.pojo.Account;
import com.intelligentCommunity.pojo.Fix;
import com.intelligentCommunity.service.AccountService;
import com.intelligentCommunity.service.FixService;

@Controller
public class FixAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private FixService fixService;
	@Resource
	private AccountService accountService;
	
	private List<Fix> fixList;
	private Fix fix;
	private boolean status;
	private int fixId;
	private String p;
	

	@Action(value="priFix")
	public String priFix(){
		status = false;
		Account user = (Account)getSession().get("user");
		Account a = accountService.findAccountById(user.getId());
		fixList = null;
		if (a.getRole().getName().equals("admin")) {
			fixList = fixService.findByStatus(user,status);
		}else{
			fixList = fixService.findByAccountAndStatus(user,status);
		}
		return SUCCESS;
	}
	
	@Action(value="pubFix")
	public String pubFix(){
		status = true;
		fixList = fixService.findByStatus((Account)getSession().get("user"),status);
		return SUCCESS;
	}
	
	
	@Action(value="addFixForm")
	public String addFixForm(){
		return SUCCESS;
	}
	
	@Action(value="addFix",results={
			@Result(name="success",type="redirectAction",params={"actionName","${p}","namespace","/fix"})})
	public String addFix(){
		p = fix.isStatus() ? "pubFix" : "priFix" ;
		fix.setAccount((Account)getSession().get("user"));
		fixService.save(fix);
		return SUCCESS;
	}
	
	@Action(value="fixDetail")
	public String fixDetail(){
		fix = fixService.findFixById(fixId);
		return SUCCESS;
	}
	
	
	@Action(value="updateFix",results={
			@Result(name="success",type="redirectAction",params={"actionName","${p}","namespace","/fix"})})
	public String updateIsOk(){
		fix = fixService.findFixById(fixId);
		p = fix.isStatus() ? "pubFix" : "priFix" ;
		fix.setIsOk(true);
		fixService.save(fix);
		return SUCCESS;
	}
	


	
	//get and set
	public List<Fix> getFixList() {
		return fixList;
	}


	public void setFixList(List<Fix> fixList) {
		this.fixList = fixList;
	}


	public Fix getFix() {
		return fix;
	}


	public void setFix(Fix fix) {
		this.fix = fix;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getFixId() {
		return fixId;
	}

	public void setFixId(int fixId) {
		this.fixId = fixId;
	}

	public String getP() {
		return p;
	}

	public void setP(String p) {
		this.p = p;
	}
	
	
	

}

