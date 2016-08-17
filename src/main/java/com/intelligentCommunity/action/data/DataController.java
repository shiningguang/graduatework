package com.intelligentCommunity.action.data;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.stereotype.Controller;

import com.google.gson.JsonParser;
import com.intelligentCommunity.action.BaseAction;
import com.intelligentCommunity.pojo.Account;

@Controller
public class DataController extends BaseAction{
	
	@Action(value="json")
	public String addAccountForm(){
		Account user = new Account();
		user.setId(1);
		user.setAddress("748347329");
		user.setDescript("dasdas");
		user.setEmail("1212");
		return NONE;
	}
	

}
