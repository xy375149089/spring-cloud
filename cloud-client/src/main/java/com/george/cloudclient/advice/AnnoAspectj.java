package com.george.cloudclient.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AnnoAspectj {
	
	private static final Logger logger = LoggerFactory.getLogger(AnnoAspectj.class);
	
	@Value("${server.port}")
	private int port;

	@Pointcut("execution(* com.george.cloudclient.service.*.*(..))")
	public void logPoint(){}
	
	
	@Before("logPoint()")
	public void testBefore(JoinPoint jp){
		logger.info("call method {} start , this port is {} " , jp.getSignature().getName() , port);
	}
	
	@After("logPoint()")
	public void testAfter(JoinPoint jp){
		logger.info("call method {} end" , jp.getSignature().getName());
	}
}
