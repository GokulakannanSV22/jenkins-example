package com.jenkins.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JenkinsController {

	@GetMapping("/")
	public String start()
	{
		return "hello";
	}
	
	@GetMapping("/homePage")
	public String home()
	{
		return "Home";
	}
}
