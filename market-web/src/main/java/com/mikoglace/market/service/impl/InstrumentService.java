package com.mikoglace.market.service.impl;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.mikoglace.market.dto.InstrumentDTO;
import com.mikoglace.market.model.Instrument;

@Service(value="instrumentService")
public class InstrumentService extends AbstractService<Long, Instrument, InstrumentDTO> {

	@Resource(name="instrumentRepository")
	@Override
	public void setRepository(JpaRepository<Instrument, Long> repository) {
		super.setRepository(repository);
	}

	@Override
	Class<InstrumentDTO> getClazz() {
		return InstrumentDTO.class;
	}

	
}
