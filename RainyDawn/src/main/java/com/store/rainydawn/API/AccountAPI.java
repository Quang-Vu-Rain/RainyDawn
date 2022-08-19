package com.store.rainydawn.API;

import com.store.rainydawn.entity.Accounts;
import com.store.rainydawn.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account")
public class AccountAPI {
    private AccountService accountService;

    public AccountAPI(AccountService accountService) {
        super();
        this.accountService = accountService;
    }

    @GetMapping
    public List<Accounts> getAllAccount() {
        return accountService.getAllAccount();
    }

    @PostMapping
    public ResponseEntity<Accounts> saveAccount(@RequestBody Accounts account) {
        return new ResponseEntity<Accounts>(accountService.saveAccount(account), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Accounts> getAccountById(@PathVariable("id") int id) {
        return new ResponseEntity<Accounts>(accountService.getAccountById(id), HttpStatus.OK);
    }

    @PostMapping("{id}")
    public ResponseEntity<Accounts> updateAccount(@PathVariable("id") int id, @RequestBody Accounts account) {
        return new ResponseEntity<Accounts>(accountService.updateAccount(account, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable("id") int id) {
        accountService.deleteAccount(id);
        return new ResponseEntity<String>("Account deleted successfully!", HttpStatus.OK);
    }
}
