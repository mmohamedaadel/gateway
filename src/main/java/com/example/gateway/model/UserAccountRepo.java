package com.example.gateway.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepo extends JpaRepository<UserAccount, Long> {
    UserAccount findUserAccountById(String userId);

    //    UserAccount findByUserAndAccount(long l1, long l2);
}
