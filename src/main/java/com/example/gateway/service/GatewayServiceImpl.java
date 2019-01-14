package com.example.gateway.service;

import com.example.gateway.client.AccountClient;
import com.example.gateway.client.model.Account;
import com.example.gateway.model.UserAccount;
import com.example.gateway.model.UserAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GatewayServiceImpl implements GatewayService {

    @Autowired
    private UserAccountRepo userAccountRepo;

    @Autowired
    private AccountClient accountClient;

    @Override
    public void addAccountToUser(String userId, String accountId) throws Exception{
        UserAccount userAccount = new UserAccount();
        userAccount.setAccountId(accountId);
        userAccount.setUserId(userId);
        userAccountRepo.save(userAccount);
    }

    @Override
    public Iterable getAllAccounts() throws Exception{

//        UserAccount userAccount = new UserAccount();

        return userAccountRepo.findAll();
    }

    @Override
    public Account getAccountInfoFromPerson(String userId) throws Exception{
        UserAccount userAccount = userAccountRepo.findUserAccountById(userId);
        return accountClient.getAccountInfo(userAccount.getAccountId());
    }
}
