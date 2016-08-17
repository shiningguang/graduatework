package com.intelligentCommunity.dao;

import java.util.List;

import com.intelligentCommunity.pojo.Role;

public interface RoleDao {


	List<Role> findAll();

	Role findRoleById(Long roleId);

}

