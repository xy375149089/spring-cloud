package com.george.cloudgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.george.cloudgateway.filter.TokenFilter;
import com.george.cloudgateway.filter.factory.VisitTimeLoggerGatewayFilterFactory;

@SpringBootApplication
@EnableEurekaClient
public class CloudgatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudgatewayApplication.class, args);
	}
	
	@Bean
	public VisitTimeLoggerGatewayFilterFactory registerFactory(){
		return new VisitTimeLoggerGatewayFilterFactory();
	}
	
	@Bean
	public TokenFilter registerGlobalFilter(){
		return new TokenFilter();
	}
}
