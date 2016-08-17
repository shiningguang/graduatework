package com.intelligentCommunity.action.house;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.intelligentCommunity.action.BaseAction;
import com.intelligentCommunity.pojo.Account;
import com.intelligentCommunity.pojo.House;
import com.intelligentCommunity.pojo.Notice;
import com.intelligentCommunity.service.AccountService;
import com.intelligentCommunity.service.HouseService;
import com.intelligentCommunity.service.NoticeService;

@Controller
public class HouseAction extends BaseAction{
	
	private static final long serialVersionUID = 1L;

	@Resource
	private HouseService houseService;
	@Resource
	private AccountService accountService;
	@Resource
	private NoticeService noticeService;
	
	
	private List<House> list;
	private House house;
	private int houseId;
	private List<Account> accountList;
	private List<Notice> noticeList;
	private Notice notice;
	private int accountId;
	private Account account;
	
	
	@Action(value="listHouse")
	public String listAllHouse(){
		list = houseService.findAllHouse();
		return SUCCESS;
	}

	@Action(value="addHouse")
	public String addHouseForm(){
		accountList = accountService.findAllAccount();
		return SUCCESS;
	}
	
	@Action(value="add",results={
			@Result(name="success",type="redirectAction",params={"actionName","listHouse","namespace","/house"})})
	public String addHouse(){
		if (StringUtils.isNotBlank(Integer.toString(accountId))) {
			house.setAccount(accountService.findAccountById(accountId));
		}
		houseService.saveOrUpdate(house);
		return SUCCESS;
	}

	@Action(value="updateHouseForm")
	public String updateHouseForm(){
		house = houseService.findHouseById(houseId);
		accountList = accountService.findAllAccount();
		return SUCCESS;
	}
	
	@Action(value="updateHouse",results={
			@Result(name="success",type="redirectAction",params={"actionName","listHouse","namespace","/house"})})
	public String updateHouse(){
		if (StringUtils.isNotBlank(Integer.toString(accountId))) {
			house.setAccount(accountService.findAccountById(accountId));
		}
		houseService.saveOrUpdate(house);
		return SUCCESS;
	}
	
	@Action(value="pubLive")
	public String pubLive(){
		noticeList = noticeService.findAllNotice();
		return SUCCESS;
	}
	
	
	@Action(value="addNoticeForm")
	public String addNoticeForm(){
		return SUCCESS;
	}
	
	@Action(value="addNotice",results={
			@Result(name="success",type="redirectAction",params={"actionName","pubLive","namespace","/house"})})
	public String addNotice(){
		noticeService.save(notice);
		return SUCCESS;
	}
	
	//get and set
	public List<House> getList() {
		return list;
	}


	public void setList(List<House> list) {
		this.list = list;
	}

	public House getHouse() {
		return house;
	}

	public void setHouse(House house) {
		this.house = house;
	}

	public int getHouseId() {
		return houseId;
	}

	public void setHouseId(int houseId) {
		this.houseId = houseId;
	}

	public List<Account> getAccountList() {
		return accountList;
	}

	public void setAccountList(List<Account> accountList) {
		this.accountList = accountList;
	}

	public List<Notice> getNoticeList() {
		return noticeList;
	}

	public void setNoticeList(List<Notice> noticeList) {
		this.noticeList = noticeList;
	}

	public Notice getNotice() {
		return notice;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
}

