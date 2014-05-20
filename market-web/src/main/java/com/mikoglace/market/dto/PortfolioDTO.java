package com.mikoglace.market.dto;

import java.util.List;

public class PortfolioDTO {

	private Long id;
	
	private List<PortfolioLineDTO> portfolioLineList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<PortfolioLineDTO> getPortfolioLineList() {
		return portfolioLineList;
	}

	public void setPortfolioLineList(List<PortfolioLineDTO> portfolioLineList) {
		this.portfolioLineList = portfolioLineList;
	}
	
}
