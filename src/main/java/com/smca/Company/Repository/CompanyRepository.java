package com.smca.Company.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smca.Company.Models.Company;

public interface CompanyRepository extends JpaRepository<Company,Long> {
	Company  findByName(String Name);
}
