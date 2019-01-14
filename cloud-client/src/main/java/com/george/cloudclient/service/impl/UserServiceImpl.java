package com.george.cloudclient.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.george.cloudclient.entity.User;
import com.george.cloudclient.mapper.UserMapper;
import com.george.cloudclient.service.RoleService;
import com.george.cloudclient.service.UserService;

@Service("testService")
public class UserServiceImpl implements UserService{
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private RoleService testService2;
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void saveUser(User user){
		userMapper.saveUser(user);
		try{
			testService2.deleteRole();
		}
		catch(Exception e){
			logger.error("catch error to keep external transaction normal. ");
		}
	}

	@Transactional
	public void batchSaveUser(List<User> userList) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userList", userList);
		userMapper.batchSaveUser(map);
	}

	public List<User> getUserList(String columnName,String columnName2){
		return userMapper.getUserList(columnName,columnName2);
	}

	public List<User> getUserByCondinton(Map<String, String> map) {
		return userMapper.getUserByCondinton(map);
	}

	public User getUserByID(long id) {
		return userMapper.getUserByID(id);
	}

}
