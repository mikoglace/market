package com.mikoglace.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mikoglace.market.model.Client;

/**
 * Spring Data JPA repository for the Client entity.
 */
@Repository(value="clientRepository")
public interface ClientRepository extends JpaRepository<Client, Long> {

}
