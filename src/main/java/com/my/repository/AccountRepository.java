package com.my.repository;

import com.my.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Integer> {
    Account getAccountById(int id);
    Account getByLogin(String login);
    boolean existsAccountByLogin(String login);
}
