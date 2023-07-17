package com.utm.jpacrud.dao;

import com.utm.jpacrud.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthDAO extends JpaRepository<Account,Integer> {


    Account findByUsername(String username);
}
