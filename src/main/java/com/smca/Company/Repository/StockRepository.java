package com.smca.Company.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smca.Company.Models.StockExchange;


public interface StockRepository extends JpaRepository<StockExchange,Long> {
	StockExchange findByName(String Name);
}
