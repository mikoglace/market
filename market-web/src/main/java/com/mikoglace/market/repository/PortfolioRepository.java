package com.mikoglace.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mikoglace.market.model.Portfolio;

/**
 * Spring Data JPA repository for the Portfolio entity.
 */
@Repository(value="portfolioRepository")
public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {

}
