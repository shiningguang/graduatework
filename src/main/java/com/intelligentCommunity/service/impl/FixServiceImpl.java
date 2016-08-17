package com.intelligentCommunity.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intelligentCommunity.dao.FixDao;
import com.intelligentCommunity.pojo.Account;
import com.intelligentCommunity.pojo.Fix;
import com.intelligentCommunity.service.FixService;

@Service(value="FixService")
@Transactional
public class FixServiceImpl implements FixService{
	
	@Resource
	private FixDao fixDao;

	public List<Fix> findByAccount(Account account) {
		return fixDao.findByAccount(account);
	}

	public void save(Fix fix) {
		fixDao.save(fix);
		
	}

	public List<Fix> findByAccountAndStatus(Account account, boolean status) {
		return fixDao.findByAccountAndStatus(account,status);
	}

	public Fix findFixById(int fixId) {
		return fixDao.findById(fixId);
	}

	public List<Fix> findByStatus(Account account, boolean status) {
		return fixDao.findByStatus(account,status);
	}

}

