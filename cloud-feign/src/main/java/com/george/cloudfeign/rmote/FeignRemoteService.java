package com.george.cloudfeign.rmote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "CLOUDCLIENT-1",fallback = FeignRemoteServiceHystric.class)
public interface FeignRemoteService {

	@RequestMapping(value = "/user/list")
    public String call();
}
