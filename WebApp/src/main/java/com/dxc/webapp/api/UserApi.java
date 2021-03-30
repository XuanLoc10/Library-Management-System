package com.dxc.webapp.api;

import com.dxc.webapp.model.User;
import com.dxc.webapp.model.UserLogin;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "user-service", url = "${zuul.routes.user-service.url}")
public interface UserApi {

	@PostMapping(value = "/auth", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	String auth(@RequestBody UserLogin user);

	@PostMapping(value = "/user/{user}", produces = MediaType.APPLICATION_JSON_VALUE)
	User findByUser(@PathVariable String user);
}
