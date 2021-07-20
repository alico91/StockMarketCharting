package com.smca.Company.Models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "CompanyStockExchangeMap")
public class CompanyStockExchangeMap {

	@Id
	@GeneratedValue
	private long id;
	
	private String CompanyCode;
	
	private String CompanyName;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Company company;
	
	private String stockExchangeName;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private StockExchange stockExchange;

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public StockExchange getStockexchange() {
		return stockExchange;
	}

	public void setStockexchange(StockExchange stockExchange) {
		this.stockExchange = stockExchange;
	}
	
	
	
	public String getStockExchangeName() {
		return stockExchangeName;
	}

	public void setStockExchangeName(String stockExchangeName) {
		this.stockExchangeName = stockExchangeName;
	}

	public StockExchange getStockExchange() {
		return stockExchange;
	}

	public void setStockExchange(StockExchange stockExchange) {
		this.stockExchange = stockExchange;
	}

	public String getCompanyName() {
		return CompanyName;
	}

	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getCompanyCode() {
		return CompanyCode;
	}

	public void setCompanyCode(String companyCode) {
		CompanyCode = companyCode;
	}
	
	public CompanyStockExchangeMap() {
		super();
		// TODO Auto-generated constructor stub
	}
}
