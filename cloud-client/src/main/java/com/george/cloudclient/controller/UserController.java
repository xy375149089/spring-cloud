package com.george.cloudclient.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.george.cloudclient.entity.User;
import com.george.cloudclient.service.UserService;

@RefreshScope
@Controller
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	
	@Value("${customer.name}")
	private String name;
	
	@RequestMapping("/index")
	@ResponseBody
	public String index(){
		logger.info("get config {} " , name);
		return name;
	}
	
	@RequestMapping(value="/user/list",produces={"application/json; charset=UTF-8"})
	@ResponseBody
	public List<User> userList(HttpServletRequest request) {
		String columnName1 = "id";
		String columnName2 = "uname";
		List<User> userList = userService.getUserList(columnName1,columnName2);
		return userList;
	}
	
	@RequestMapping(value="/user/queryUser",produces={"application/json; charset=UTF-8"})
	@ResponseBody
	public List<User> queryUser(User user) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("uname", user.getuName());
		map.put("usex", user.getuSex());
		List<User> userList = userService.getUserByCondinton(map);
		return userList;
	}
	
	@RequestMapping(value="/user/{id}",produces={"application/json; charset=UTF-8"})
	@ResponseBody
	public User getUserById(@PathVariable("id") long id) {
		User user = userService.getUserByID(id);
		return user;
	}
	
	@RequestMapping(value="/user/save",produces={"application/json; charset=UTF-8"})
	@ResponseBody
	public User userSave(){
		User u = new User("Ge","M");
		userService.saveUser(u);
		return u;
	}
	
	@RequestMapping("/user/batchSave")
	public ModelAndView batchSave(){
		List<User> userList = new ArrayList<User>();
		userList.add(new User("Be","F"));
		userList.add(new User("Br","M"));
		userService.batchSaveUser(userList);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("userList", userList);
		mv.setViewName("main");
		return mv;
	}
}