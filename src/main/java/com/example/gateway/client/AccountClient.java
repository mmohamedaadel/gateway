package com.example.gateway.client;

import com.example.gateway.client.model.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("demo")
public interface AccountClient {

    @GetMapping(path = "/{accountId}")
    Account getAccountInfo(@PathVariable("accountId") String accountId) throws Exception;

    @PostMapping(path = "")
    void createAccount(Account account) throws Exception;

    @GetMapping(path = "")
    Iterable getAccounts();
}
