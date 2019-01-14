package com.george.cloudzuul.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class TokenFilter extends ZuulFilter{
	
	private static final Logger logger = LoggerFactory.getLogger(TokenFilter.class);

	@Override
	public boolean shouldFilter() {
		//是否要过滤
		return true;
	}

	@Override
	public String filterType() {
		//pre：路由之前   , routing：路由之时  , post： 路由之后  , error：发送错误调用
		return "pre";
	}

	@Override
	public int filterOrder() {
		//过滤的顺序
		return 0;
	}

	@Override
	public Object run() throws ZuulException {
		//过滤器的具体逻辑
		RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        logger.info(" request url :" ,  request.getRequestURL().toString());
        Object accessToken = request.getParameter("token");
        if(accessToken == null) {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            }catch (Exception e){
            	logger.info(" filter error {} " ,  e.getMessage());
            }
        }
		return null;
	}
}
