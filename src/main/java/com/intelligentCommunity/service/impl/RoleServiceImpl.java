package com.intelligentCommunity.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intelligentCommunity.dao.RoleDao;
import com.intelligentCommunity.pojo.Role;
import com.intelligentCommunity.service.RoleService;

@Service(value="RoleService")
@Transactional
public class RoleServiceImpl implements RoleService{

	@Resource
	private RoleDao roleDao;
	
	public List<Role> findAll() {
		return roleDao.findAll();
	}

	public Role findRoleById(Long roleId) {
		return roleDao.findRoleById(roleId);
	}

}

