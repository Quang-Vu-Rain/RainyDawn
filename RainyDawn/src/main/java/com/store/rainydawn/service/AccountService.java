package com.store.rainydawn.service;

import com.store.rainydawn.entity.Accounts;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface AccountService {

    List<Accounts> getAllAccount();
    Accounts saveAccount(Accounts account);
    Accounts getAccountById(int id);
    Accounts updateAccount(Accounts account, int id);
    void deleteAccount(int id);
}
