package com.mikoglace.market.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Where;


/**
 * The persistent class for the instrument database table.
 * 
 */
@Entity
@Table(name="INSTRUMENT")
public class Instrument implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="INST_ID")
	private Long id;

	@Column(name="INST_ISIN")
	private String isin;
	
	@Column(name="INST_MNEMO_CODE")
	private String mnemoCode;
	
	@Column(name="INST_LABEL")
	private String label;

	@Column(name="INST_DESCRIPTION")
	private String description;

	@Column(name="INST_ACTIVE")
	@Where(clause="INST_ACTIVE = 1")
	private boolean active;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="INST_ACTIVE_DATE")
	private Date activeDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="INST_CREATION_DATE")
	private Date creationDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="INST_UPDATE_DATE")
	private Date updateDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="INST_CLOSE_DATE")
	private Date closeDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIsin() {
		return isin;
	}

	public void setIsin(String isin) {
		this.isin = isin;
	}

	public String getMnemoCode() {
		return mnemoCode;
	}

	public void setMnemoCode(String mnemoCode) {
		this.mnemoCode = mnemoCode;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getActiveDate() {
		return activeDate;
	}

	public void setActiveDate(Date activeDate) {
		this.activeDate = activeDate;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Date getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}

}