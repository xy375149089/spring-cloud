package com.george.cloudrobin.rmote;

import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;

@Service
public class RibbonRmoteService {

	private static final Logger logger = LoggerFactory.getLogger(RibbonRmoteService.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod="callError", commandProperties={@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="5000")})
	public String call(){
		logger.info(" call ribbon service method started");
		return restTemplate.getForObject("http://cloudclient/user/list",String.class);
	}
	
	@HystrixCommand(fallbackMethod="callError")
	public Future<String> asyncCall(){
		return new AsyncResult<String>(){
			public String invoke(){
				return restTemplate.getForObject("http://cloudclient/user/list",String.class);
			}
		};
	}
	
	public String callError(){
		logger.info(" robbin hystric execute !");
		return "robbin hystric execute";
	}
}
