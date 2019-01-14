package com.george.cloudrobin.rmote;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class RibbonRmoteService {

	private static final Logger logger = LoggerFactory.getLogger(RibbonRmoteService.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod="callError")
	public String call(){
		logger.info(" call ribbon service method started");
		return restTemplate.getForObject("http://cloudclient-1/user/list",String.class);
	}
	
	public String callError(){
		logger.info(" robbin hystric execute !");
		return "robbin hystric execute";
	}
}
