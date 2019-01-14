package com.george.cloudclient.service;

import java.util.List;
import java.util.Map;

import com.george.cloudclient.entity.User;

public interface UserService {
	
	void saveUser(User user);
	
	void batchSaveUser(List<User> userList);
	
	List<User> getUserList(String columnName1,String columnName2);
	
	List<User> getUserByCondinton(Map<String,String> map);
	
	User getUserByID(long id);

}
