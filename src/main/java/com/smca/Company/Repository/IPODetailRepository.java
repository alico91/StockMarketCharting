package com.smca.Company.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smca.Company.Models.IPODetail;

@Repository
public interface IPODetailRepository extends JpaRepository<IPODetail, Long> {
	public IPODetail findByName(String companyName);
}
