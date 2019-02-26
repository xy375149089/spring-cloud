package com.george.cloudgateway.filter.factory;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;

import reactor.core.publisher.Mono;

public class VisitInfoGatewayFilterFactory extends AbstractGatewayFilterFactory<VisitInfoGatewayFilterFactory.Config>{
	
	private static final Logger logger = LoggerFactory.getLogger(VisitInfoGatewayFilterFactory.class);

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("flag");
    }

    public VisitInfoGatewayFilterFactory() {
        super(Config.class);
    }
	
	@Override
	public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            return chain.filter(exchange).then(
                Mono.fromRunnable(() -> {
                	if(config.isFlag()){
                		logger.info(" get vister host {} " , exchange.getRequest().getRemoteAddress().getHostName());
                	}
                })
            );
        };
	}

	public static class Config {

		protected boolean flag;

		public boolean isFlag() {
			return flag;
		}

		public void setFlag(boolean flag) {
			this.flag = flag;
		}
    }
}
