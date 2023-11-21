package com.tucine.comments.Clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "account-managment-service",path = "/api/TuCine/v1/account_management/")
public interface UserClient {
    @RequestMapping("/users/verify/{userId}")
    boolean checkIfUserExists(@PathVariable("userId") Long userId) throws RuntimeException;
}
