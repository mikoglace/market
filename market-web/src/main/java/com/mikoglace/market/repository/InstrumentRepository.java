package com.mikoglace.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mikoglace.market.model.Instrument;

/**
 * Spring Data JPA repository for the Instrument entity.
 */
@Repository(value="instrumentRepository")
public interface InstrumentRepository extends JpaRepository<Instrument, Long> {

}
