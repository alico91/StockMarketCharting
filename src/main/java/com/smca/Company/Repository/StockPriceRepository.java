package com.smca.Company.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smca.Company.Models.StockPrice;

public interface StockPriceRepository extends JpaRepository<StockPrice,Long> {

}
