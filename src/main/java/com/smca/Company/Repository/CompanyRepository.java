package com.smca.Company.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smca.Company.Models.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {
	public Company findByName(String Name);
}
