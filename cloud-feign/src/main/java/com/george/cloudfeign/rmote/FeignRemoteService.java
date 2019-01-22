package com.george.cloudfeign.rmote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "cloudclient",fallback = FeignRemoteServiceHystric.class)
public interface FeignRemoteService {

	@RequestMapping(value = "/user/list")
    public String call();
}
