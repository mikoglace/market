package com.mikoglace.market.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Where;


/**
 * The persistent class for the client database table.
 * 
 */
@Entity
@Table(name="CLIENT")
public class Client implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CLI_ID")
	private Long id;

	@Column(name="CLI_LASTNAME")
	private String lastname;

	@Column(name="CLI_FIRSTNAME")
	private String firstname;

	@Column(name="CLI_INTERNAL_REF")
	private String internalRef;
	
	@Column(name="CLI_ACTIVE")
	@Where(clause="CLI_ACTIVE = 1")
	private boolean active;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CLI_CREATION_DATE")
	private Date creationDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CLI_UPDATE_DATE")
	private Date updateDate;
	
	@ManyToMany(targetEntity=Account.class/*, fetch=FetchType.EAGER*/)
	@JoinTable(
		name="CLIENT_ACCOUNT"
		, joinColumns={
			@JoinColumn(name="CLI_ID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="ACC_ID")
			}
		)
	private List<Account> accountList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
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

	public List<Account> getAccountList() {
		return accountList;
	}

	public void setAccountList(List<Account> accountList) {
		this.accountList = accountList;
	}

}