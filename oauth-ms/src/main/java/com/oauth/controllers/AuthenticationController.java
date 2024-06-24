package com.oauth.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/oauth/v1")
public class AuthenticationController {

	@GetMapping("/test")
	public String testRequest() {
		// System.out.println(user);
		return "ok";
	}
}