package com.intelligentCommunity.service;

import java.util.List;

import com.intelligentCommunity.pojo.Account;
import com.intelligentCommunity.pojo.Fix;

public interface FixService {

	List<Fix> findByAccount(Account account);

	void save(Fix fix);

	List<Fix> findByAccountAndStatus(Account account, boolean status);

	Fix findFixById(int fixId);

	List<Fix> findByStatus(Account account, boolean status);

}

