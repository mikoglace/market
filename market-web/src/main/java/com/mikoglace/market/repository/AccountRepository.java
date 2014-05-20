package com.mikoglace.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mikoglace.market.model.Account;

/**
 * Spring Data JPA repository for the Account entity.
 */
@Repository(value="accountRepository")
public interface AccountRepository extends JpaRepository<Account, Long> {

}
