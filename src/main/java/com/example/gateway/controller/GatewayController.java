package com.example.gateway.controller;

import com.example.gateway.client.AccountClient;
import com.example.gateway.client.UserClient;
import com.example.gateway.client.model.Account;
import com.example.gateway.service.GatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GatewayController {

    @Autowired
    private AccountClient accountClient;

    @Autowired
    private UserClient userClient;

    @Autowired
    private GatewayService gatewayService;

    public GatewayController() {

    }

    public GatewayController(AccountClient accountClient, UserClient userClient) {
        this.accountClient = accountClient;
        this.userClient = userClient;
    }

    @PostMapping(path = "/user/{userId}/account/{accountId}")
    public void addAccountToUser(@PathVariable String userId, @PathVariable String accountId) throws Exception {
        gatewayService.addAccountToUser(userId, accountId);
    }

    @GetMapping(path = "/allData")
    public Iterable getAllAccounts() throws Exception {
        Iterable iterable = gatewayService.getAllAccounts();
        return iterable;
    }

    @PostMapping(path = "")
    public void createAccount(@RequestBody Account account) throws Exception {
        accountClient.createAccount(account);
    }

    @GetMapping(path="/{accountId}")
    public Account getAccount(@PathVariable("accountId") String accountId) throws Exception {
        return accountClient.getAccountInfo(accountId);
    }

    @GetMapping(path="")
    public Iterable getAccounts() throws Exception {
        return accountClient.getAccounts();
    }
}
