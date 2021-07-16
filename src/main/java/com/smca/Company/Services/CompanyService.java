package com.smca.Company.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.smca.Company.Models.Company;
import com.smca.Company.Models.IPODetail;
import com.smca.Company.Models.StockPrice;
import com.smca.Company.Repository.CompanyRepository;
import com.smca.Company.Repository.StockExchangeRepository;

@Service
public class CompanyService {
	
	@Autowired
	CompanyRepository companyRepository;
	
	@Autowired
	StockExchangeRepository stockRepository;
	
	public List<Company> getCompanies(){
		return companyRepository.findAll();
	}
	
	public Company findById(Long id) {
		Optional<Company> company = companyRepository.findById(id);
		return company.get();
	}

	public IPODetail getCompanyIpoDetails(Long id) {
		Optional<Company> company = companyRepository.findById(id);
		IPODetail ipo = company.get().getIpo();
		return ipo;
	}


	public Object addCompany(Company company) {
		companyRepository.save(company);
		return null;
	}

	public void deleteCompany(Long id) {
		Optional<Company> company = companyRepository.findById(id);
		Company comp = company.get();
		companyRepository.delete(comp);
	}

	public Company editCompany(Company company) {
		if(findById(company.getId()) == null)
			return null;
		Company updatedCompany = companyRepository.save(company);
		return updatedCompany;
		
	}
	
	
	
	
	
	
	
}
