package com.george.cloudrobin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.george.cloudrobin.rmote.RibbonRmoteService;

@RestController
public class RibbonController {

	private static final Logger logger = LoggerFactory.getLogger(RibbonController.class);
	
	@Autowired
	private RibbonRmoteService ribbonRmoteService;
	
	@Value("${server.port}")
	private int port;
	
	@RequestMapping("/robbinCall")
	public String robbinCall(){
		logger.info(" call robbin controller method started this port is {}" , port);
		return ribbonRmoteService.call();
	}
}
