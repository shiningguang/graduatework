package com.intelligentCommunity.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intelligentCommunity.dao.AccountDao;
import com.intelligentCommunity.pojo.Account;
import com.intelligentCommunity.service.AccountService;

@Service(value="AccountService")
@Transactional
public class AccountServiceImpl implements AccountService {

	@Inject
	private AccountDao accountDao;
	
	public Account findAccountByEmailAndPassword(String email, String password) {
		return accountDao.findByEmailAndPassword(email, password);
	}

	public void saveOrUpdate(Account account) {
		accountDao.saveOrUpdate(account);
	}

	public List<Account> findAllAccount() {
		return accountDao.findAllAccount();
	}

	public Account findAccountById(int accountId) {
		return accountDao.findAccountById(accountId);
	}

	public void delAccountById(int accountId) {
		accountDao.delAccountById(accountId);
	}

	public Account findByAccountName(String username) {
		return accountDao.findByAccountEmail(username);
	}

	public Account findAccountByEmail(String email) {
		return accountDao.findByAccountEmail(email);
	}

}

