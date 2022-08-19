package com.store.rainydawn.service.impl;

import com.store.rainydawn.dao.AccountDAO;
import com.store.rainydawn.entity.Accounts;
import com.store.rainydawn.entity.Roles;
import com.store.rainydawn.exception.ResourceNotFoundException;
import com.store.rainydawn.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AccountServiceImpl implements AccountService {
    private AccountDAO accountDAO;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public AccountServiceImpl(AccountDAO accountDAO) {
        super();
        this.accountDAO = accountDAO;
    }

    @Override
    public Accounts saveAccount(Accounts account) {
        account.setPassword(bCryptPasswordEncoder.encode(account.getPassword()));
        return accountDAO.save(account);
    }

    @Override
    public List<Accounts> getAllAccount() {
        return accountDAO.findAll();
    }

    @Override
    public Accounts getAccountById(int id) {
//        Optional<Accounts> account = accountDAO.findById(id);
//        if(account.isPresent()){
//            return account.get();
//        }else {
//            throw new ResourceNotFoundException("Account", "Id", id);
//        }
        return accountDAO.findById(id).orElseThrow(() -> new ResourceNotFoundException("Account", "Id", id));
    }

    @Override
    public Accounts updateAccount(Accounts account, int id) {
        Accounts existringAccount = accountDAO.findById(id).orElseThrow(() -> new ResourceNotFoundException("Account", "Id", id));
        existringAccount.setFullname(account.getFullname());
        existringAccount.setEmail(account.getEmail());
        existringAccount.setFullname(account.getFullname());
        existringAccount.setFullname(account.getFullname());
        existringAccount.setFullname(account.getFullname());
        existringAccount.setFullname(account.getFullname());
        accountDAO.save(existringAccount);
        return existringAccount;
    }

    @Override
    public void deleteAccount(int id) {
        accountDAO.findById(id).orElseThrow(() -> new ResourceNotFoundException("Account", "Id", id));
        accountDAO.deleteById(id);
    }
}
