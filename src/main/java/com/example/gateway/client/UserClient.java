package com.example.gateway.client;

import com.example.gateway.client.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resources;

@FeignClient("user")
public interface UserClient {

    @GetMapping(path = "/user")
    Iterable<User> getUsers() throws Exception;
}
