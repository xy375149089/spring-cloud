package com.george.cloudgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.george.cloudgateway.filter.HeaderGlobalFilter;
import com.george.cloudgateway.filter.factory.VisitInfoGatewayFilterFactory;
import com.george.cloudgateway.rate.limiter.HostAddrKeyResolver;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudgatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudgatewayApplication.class, args);
	}
	
	@Bean
	public VisitInfoGatewayFilterFactory registerGatewayFactory(){
		return new VisitInfoGatewayFilterFactory();
	}
	
	@Bean
	public HeaderGlobalFilter registerGlobalFilter(){
		return new HeaderGlobalFilter();
	}
	
	@Bean
    public HostAddrKeyResolver hostAddrKeyResolver() {
        return new HostAddrKeyResolver();
    }
}
