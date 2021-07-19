package com.smca.Company.Models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="ipo")
public class IPODetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ipo_id")
	private Long ipoId;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="stock_exchange_id")
	private int stockExchangeId;
	
	@Column(name="price_per_share")
	private float pricePerShare;
	
	@Column(name="total_number_of_shares")
	private int totalNumberOfShares;
	
	@Column(name="open_date_time")
	private Date openDateTime;
	
	@Column(name="ipo_remarks")
	private String ipoRemarks;
	
	@OneToOne
	@JsonIgnore
	private Company Company;
	
	@ManyToMany
	private List<StockExchange> stockExchanges = new ArrayList<>();
	
	
	
	public Company getCompany() {
		return Company;
	}

	public void setCompany(Company company) {
		Company = company;
	}

	public List<StockExchange> getStockExchanges() {
		return stockExchanges;
	}

	public void setStockExchanges(List<StockExchange> stockExchanges) {
		this.stockExchanges = stockExchanges;
	}

	public Long getIpoId() {
		return ipoId;
	}

	public void setIpoId(Long ipoId) {
		this.ipoId = ipoId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getStockExchangeId() {
		return stockExchangeId;
	}

	public void setStockExchangeId(int stockExchangeId) {
		this.stockExchangeId = stockExchangeId;
	}

	public float getPricePerShare() {
		return pricePerShare;
	}

	public void setPricePerShare(float pricePerShare) {
		this.pricePerShare = pricePerShare;
	}

	public int getTotalNumberOfShares() {
		return totalNumberOfShares;
	}

	public void setTotalNumberOfShares(int totalNumberOfShares) {
		this.totalNumberOfShares = totalNumberOfShares;
	}

	public Date getOpenDateTime() {
		return openDateTime;
	}

	public void setOpenDateTime(Date openDateTime) {
		this.openDateTime = openDateTime;
	}

	public String getIpoRemarks() {
		return ipoRemarks;
	}

	public void setIpoRemarks(String ipoRemarks) {
		this.ipoRemarks = ipoRemarks;
	}
	
	protected IPODetail() {
		
	}

	public IPODetail(float pricePerShare, int totalNumberOfShares, Date openDateTime) {
		super();
		this.pricePerShare = pricePerShare;
		this.totalNumberOfShares = totalNumberOfShares;
		this.openDateTime = openDateTime;
	}
	
	
	
	
}
