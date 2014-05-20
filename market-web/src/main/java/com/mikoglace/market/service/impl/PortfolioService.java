package com.mikoglace.market.service.impl;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.mikoglace.market.dto.PortfolioDTO;
import com.mikoglace.market.model.Portfolio;

@Service(value="portfolioService")
public class PortfolioService extends AbstractService<Long, Portfolio, PortfolioDTO> {

	@Resource(name="portfolioRepository")
	@Override
	public void setRepository(JpaRepository<Portfolio, Long> repository) {
		super.setRepository(repository);
	}

	@Override
	Class<PortfolioDTO> getClazz() {
		return PortfolioDTO.class;
	}

	
}
