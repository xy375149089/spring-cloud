package com.george.cloudgateway.filter;

import java.util.List;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

public class HeaderGlobalFilter implements GlobalFilter, Ordered{

	private static final Logger logger=LoggerFactory.getLogger(HeaderGlobalFilter.class);
	
	@Override
	public int getOrder() {
		return 0;
	}

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        HttpHeaders httpHeader = exchange.getRequest().getHeaders();
        for(Entry<String, List<String>> entry: httpHeader.entrySet()){
        	 logger.info( " key : {} , value {} " , entry.getKey() , entry.getValue());
        }
        return chain.filter(exchange);
	}
}
