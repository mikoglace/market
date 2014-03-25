package com.mikoglace.market.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Where;


/**
 * The persistent class for the portfolio_line database table.
 * 
 */
@Entity
@Table(name="PORTFOLIO_LINE")
public class PortfolioLine implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="POR_LINE_ID")
	private Long id;
	
	@Column(name="POR_LINE_QUANTITY")
	private BigDecimal quantity;
	
	@Column(name="POR_LINE_UNIT_PRICE")
	private BigDecimal unitPrice;

	@ManyToOne(targetEntity=Instrument.class)
	@JoinColumn(name="INST_ID")
	private Instrument instrument;

	@ManyToOne(targetEntity=Portfolio.class)
	@JoinColumn(name="POR_ID")
	private Portfolio portfolio;

	@Column(name="POR_LINE_ACTIVE")
	@Where(clause="POR_LINE_ACTIVE = 1")
	private boolean active;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="POR_LINE_CREATION_DATE")
	private Date creationDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="POR_LINE_CLOSE_DATE")
	private Date closeDate;

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

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Instrument getInstrument() {
		return instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

	public Portfolio getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(Portfolio portfolio) {
		this.portfolio = portfolio;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}

}