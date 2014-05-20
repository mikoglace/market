package com.mikoglace.market.dto;

import java.math.BigDecimal;

public class PortfolioLineDTO {

	private Long id;
	
	private BigDecimal quantity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	
}
