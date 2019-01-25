package com.george.cloudconsul.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

	@RequestMapping("health")
	public String health(){
		return "{status:\"success\"}";
	}
}
