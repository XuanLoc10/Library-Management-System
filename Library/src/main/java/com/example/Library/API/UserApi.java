package com.example.Library.API;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("user-service")
public interface UserApi {
    @GetMapping(value ="/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getUsers();
}
