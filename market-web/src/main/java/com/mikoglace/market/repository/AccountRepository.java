package com.mikoglace.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mikoglace.market.model.Portfolio;

/**
 * Spring Data JPA repository for the Account entity.
 */
public interface AccountRepository extends JpaRepository<Portfolio, Long> {

}
