package com.intelligentCommunity.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.intelligentCommunity.dao.RoleDao;
import com.intelligentCommunity.pojo.Role;

@Repository(value="RoleDao")
@Transactional
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao{

	public Role findRoleById(Long roleId) {
		return findById(roleId);
	}

}

