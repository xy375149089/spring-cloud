package com.george.cloudclient.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.george.cloudclient.mapper.UserMapper;
import com.george.cloudclient.service.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService{

	@Autowired
	private UserMapper userMapper;
	
	@Transactional
	public void deleteRole() {
		userMapper.deleteRole();
	}
}
