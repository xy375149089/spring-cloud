package com.george.cloudclient;

import java.io.IOException;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("com.george.cloudclient.mapper")
@EnableEurekaClient
@RefreshScope
public class CloudClientApplication extends SpringBootServletInitializer{

	public static void main(String[] args) throws IOException {
		SpringApplication.run(CloudClientApplication.class);	
	}
}
