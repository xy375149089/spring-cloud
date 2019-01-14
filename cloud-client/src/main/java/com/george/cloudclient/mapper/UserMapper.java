package com.george.cloudclient.mapper;

import java.util.List;
import java.util.Map;

import com.george.cloudclient.entity.User;

public interface UserMapper {
	
	void saveUser(User user);
	
	void batchSaveUser(Map<String,Object> map);

	List<User> getUserList(String columnName,String uanme);
	
	List<User> getUserByCondinton(Map<String,String> map);
	
	User getUserByID(long id);
	
	void deleteRole();
	
}
