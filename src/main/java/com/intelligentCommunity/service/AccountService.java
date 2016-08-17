package com.intelligentCommunity.service;

import java.util.List;

import com.intelligentCommunity.pojo.Account;

public interface AccountService {

	Account findAccountByEmailAndPassword(String email,String password);

	void saveOrUpdate(Account account);

	List<Account> findAllAccount();

	Account findAccountById(int accountId);

	void delAccountById(int accountId);

	Account findByAccountName(String username);

	Account findAccountByEmail(String email);
}

