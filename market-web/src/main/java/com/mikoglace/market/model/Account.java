package com.mikoglace.market.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Where;


/**
 * The persistent class for the account database table.
 * 
 */
@Entity
@Table(name="ACCOUNT")
@Inheritance(strategy=InheritanceType.JOINED)
public class Account implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ACC_ID")
	private Long id;
	
	@Column(name="ACC_EXTERNAL_REF")
	private String externalRef;

	@Column(name="ACC_INTERNAL_REF")
	private String internalRef;

	@Column(name="ACC_ACTIVE")
	@Where(clause="ACC_ACTIVE = 1")
	private boolean active;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ACC_CREATION_DATE")
	private Date creationDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ACC_UPDATE_DATE")
	private Date updateDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ACC_CLOSE_DATE")
	private Date closeDate;
	
	@ManyToMany(targetEntity=Portfolio.class)
	@JoinTable(
		name="CLIENT_ACCOUNT"
		, joinColumns={
			@JoinColumn(name="CLI_ID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="ACC_ID")
			}
		)
	private List<Client> clientList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getExternalRef() {
		return externalRef;
	}

	public void setExternalRef(String externalRef) {
		this.externalRef = externalRef;
	}

	public String getInternalRef() {
		return internalRef;
	}

	public void setInternalRef(String internalRef) {
		this.internalRef = internalRef;
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

	public List<Client> getClientList() {
		return clientList;
	}

	public void setClientList(List<Client> clientList) {
		this.clientList = clientList;
	}

}