package com.smca.Company.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smca.Company.Models.StockExchange;


public interface StockExchangeRepository extends JpaRepository<StockExchange,Long> {
	StockExchange findByName(String Name);
}
