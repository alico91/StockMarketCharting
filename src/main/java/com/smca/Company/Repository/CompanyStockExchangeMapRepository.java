package com.smca.Company.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smca.Company.Models.CompanyStockExchangeMap;


@Repository
public interface CompanyStockExchangeMapRepository extends JpaRepository<CompanyStockExchangeMap,Long>{

	CompanyStockExchangeMap findByCompanyCode(String companyCode);
	
}
