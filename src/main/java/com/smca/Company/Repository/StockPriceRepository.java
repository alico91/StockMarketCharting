package com.smca.Company.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smca.Company.Models.StockPrice;

public interface StockPriceRepository extends JpaRepository<StockPrice,Long> {
	public List<StockPrice> findByCompanyCodeAndExchangeName(String companyCode, String exchangeName); 
}
