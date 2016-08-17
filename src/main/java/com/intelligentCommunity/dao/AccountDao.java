package com.intelligentCommunity.dao;

import java.util.List;

import com.intelligentCommunity.pojo.Account;

public interface AccountDao {

	public Account findByEmailAndPassword(String email,String password);

	public void saveOrUpdate(Account account);

	public List<Account> findAllAccount();

	public Account findAccountById(int accountId);

	public void delAccountById(int accountId);

	public Account findByAccountEmail(String username);

	
}

