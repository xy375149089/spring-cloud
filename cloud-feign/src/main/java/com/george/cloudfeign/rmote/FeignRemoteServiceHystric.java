package com.george.cloudfeign.rmote;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class FeignRemoteServiceHystric implements FeignRemoteService{

	private static final Logger logger = LoggerFactory.getLogger(FeignRemoteServiceHystric.class);
	
	@Override
	public String call() {
		logger.info(" feign hystric execute !");
		return "feign hystric execute !";
	}

}
