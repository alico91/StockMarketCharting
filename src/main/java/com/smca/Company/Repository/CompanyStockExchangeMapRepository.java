package com.smca.Company.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smca.Company.Models.CompanyStockExchangeMap;



public interface CompanyStockExchangeMapRepository extends JpaRepository<CompanyStockExchangeMap,Long>{

	CompanyStockExchangeMap findByCompanyCode(String companyCode);
	
}
