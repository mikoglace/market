package com.mikoglace.market.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the portfolio database table.
 * 
 */
@Entity
@Table(name="PORTFOLIO")
public class Portfolio implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="POR_ID")
	private Long id;

	@OneToMany(mappedBy="portfolio", targetEntity=PortfolioLine.class/*, fetch=FetchType.EAGER*/)
	private List<PortfolioLine> portfolioLineList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<PortfolioLine> getPortfolioLineList() {
		return portfolioLineList;
	}

	public void setPortfolioLineList(List<PortfolioLine> portfolioLineList) {
		this.portfolioLineList = portfolioLineList;
	}

}