package com.george.cloudfeign.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.george.cloudfeign.rmote.FeignRemoteService;


@RestController
public class FeignController {

	private static final Logger logger = LoggerFactory.getLogger(FeignController.class);
	
	@Autowired
	private FeignRemoteService feignRemoteService;
	
	@Value("${server.port}")
	private int port;
	
	@RequestMapping("/feignCall")
	public String robbinCall(){
		logger.info(" call feign controller method started , this port is {}" , port);
		return feignRemoteService.call();
	}
}
