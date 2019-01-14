package com.example.gateway.service;

import com.example.gateway.client.model.Account;

public interface GatewayService {
    void addAccountToUser(String userId, String accountId) throws Exception;

    Iterable getAllAccounts() throws Exception;

    Account getAccountInfoFromPerson(String userId) throws Exception;
}
