package com.intelligentCommunity.service;

import java.util.List;

import com.intelligentCommunity.pojo.Role;

public interface RoleService {

	List<Role> findAll();

	Role findRoleById(Long roleId);

	
}

