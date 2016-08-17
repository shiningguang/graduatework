package com.intelligentCommunity.dao;

import java.util.List;

import com.intelligentCommunity.pojo.Account;
import com.intelligentCommunity.pojo.Fix;

public interface FixDao {

	List<Fix> findByAccount(Account account);

	void save(Fix fix);

	List<Fix> findByAccountAndStatus(Account account, boolean status);

	Fix findById(int fixId);

	List<Fix> findByStatus(Account account, boolean status);

}

