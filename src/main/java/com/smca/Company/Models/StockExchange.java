package com.smca.Company.Models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "StockExchange")
public class StockExchange {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	
	@OneToMany(targetEntity = CompanyStockExchangeMap.class)
	private List<CompanyStockExchangeMap> compstockmap;
	
	public StockExchange() {
		super();
		
		// TODO Auto-generated constructor stub
	}
	
	public StockExchange(String name) {
		super();
		this.name =name;
		// TODO Auto-generated constructor stub
	}
	
	public StockExchange(String name, List<CompanyStockExchangeMap> compstockmap) {
		super();
		this.name = name;
		this.compstockmap = compstockmap;
	}
	public List<CompanyStockExchangeMap> getCompstockmap() {
		return compstockmap;
	}

	public void setCompstockmap(List<CompanyStockExchangeMap> compstockmap) {
		this.compstockmap = compstockmap;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name =name;
	}

}
