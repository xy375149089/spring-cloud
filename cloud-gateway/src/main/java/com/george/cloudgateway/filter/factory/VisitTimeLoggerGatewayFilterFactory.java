package com.george.cloudgateway.filter.factory;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;

import reactor.core.publisher.Mono;

public class VisitTimeLoggerGatewayFilterFactory extends AbstractGatewayFilterFactory<VisitTimeLoggerGatewayFilterFactory.Config>{
	
	private static final Logger logger = LoggerFactory.getLogger(VisitTimeLoggerGatewayFilterFactory.class);

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("flag");
    }

    public VisitTimeLoggerGatewayFilterFactory() {
        super(Config.class);
    }
	
	@Override
	public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            return chain.filter(exchange).then(
                Mono.fromRunnable(() -> {
                    if (config.getFlag().equals("ON")) {
                        logger.info("params : {} " , exchange.getRequest().getQueryParams());
                    }
                })
            );
        };
	}

	public static class Config {

		protected String flag;

		public String getFlag() {
			return flag;
		}

		public void setFlag(String flag) {
			this.flag = flag;
		}
    }
}
