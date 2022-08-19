package com.store.rainydawn.dao;

import com.store.rainydawn.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDAO extends JpaRepository<Accounts, Integer> {
    Accounts findByUsername(String username);
}
