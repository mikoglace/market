package com.mikoglace.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mikoglace.market.model.Instrument;

/**
 * Spring Data JPA repository for the Instrument entity.
 */
public interface InstrumentRepository extends JpaRepository<Instrument, Long> {

}
