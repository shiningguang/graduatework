package com.intelligentCommunity.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.intelligentCommunity.dao.AccountDao;
import com.intelligentCommunity.pojo.Account;
import com.intelligentCommunity.util.PasswordUtil;

@Repository(value="AccountDao")
@Transactional
public class AccountDaoImpl extends BaseDaoImpl<Account> implements AccountDao{

	public Account findByEmailAndPassword(String email, String password) {
		if (StringUtils.isNotBlank(email)&&StringUtils.isNotBlank(password)) {
			Account account = (Account)findObjectByProperty("email", email);
			if (account != null && PasswordUtil.mixSaltPassword(email, password).equals(account.getPassword())) {
				return account;
			}
		}
		return null;
	}

	public void saveOrUpdate(Account account) {
		if (account.getPassword() == null) {
			account.setPassword(PasswordUtil.mixSaltPassword(account.getEmail(), "88888888"));
		}
		save(account);
	}

	public List<Account> findAllAccount() {
		return findAll();
	}

	public Account findAccountById(int accountId) {
		return findById(accountId);
	}

	public void delAccountById(int accountId) {
		del(accountId);
	}

	public Account findByAccountEmail(String email) {
		return findObjectByProperty("email", email);
	}
}

