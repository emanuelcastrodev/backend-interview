package com.store.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@Component
@FeignClient(name = "test", url = "http://localhost:9001", path = "/oauth/v1")
public interface TestClient {

	@GetMapping("/test")
	public String testRequest(@RequestHeader(value = "Authorization") String token,
			@RequestHeader(value = "Cookie") String cookie);
}
