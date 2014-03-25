package com.mikoglace.market.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * The persistent class for the securities_account database table.
 * 
 */
@Entity
@Table(name="SECURITIES_ACCOUNT")
public class SecuritiesAccount extends Account {
	
	private static final long serialVersionUID = 1L;

	@OneToOne(targetEntity=Portfolio.class)
	@JoinColumn(name="POR_ID")
	private Portfolio portfolio;

	public Portfolio getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(Portfolio portfolio) {
		this.portfolio = portfolio;
	}

}