package com.smca.Company.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.smca.Company.Models.Company;
import com.smca.Company.Models.Ipo;
import com.smca.Company.Models.Sector;
import com.smca.Company.Models.StockPrice;
import com.smca.Company.Repository.CompanyRepository;
import com.smca.Company.Repository.IpoRepository;
import com.smca.Company.Repository.SectorRepository;
import com.smca.Company.Repository.StockExchangeRepository;

@Service
public class CompanyService {
	
	@Autowired
	CompanyRepository companyRepository;
	
	@Autowired
	StockExchangeRepository stockRepository;
	
	@Autowired
	private SectorRepository sectorrepo;
	
	@Autowired
	private IpoRepository iporepo;
	
	public List<Company> getCompanies(){
		return companyRepository.findAll();
	}
	
	public Company findById(Long id) {
		Optional<Company> company = companyRepository.findById(id);
		return company.get();
	}

	public Ipo getCompanyIpoDetails(Long id) {
		Optional<Company> company = companyRepository.findById(id);
		Ipo ipo = company.get().getIpo();
		return ipo;
	}


	public Company addCompany(Company company) {
		Sector sector = sectorrepo.findByName(company.getSectorName());
		if(sector==null)
        	return null;
        company.setSector(sector);
		company = companyRepository.save(company);
		return company;
	}

	public void deleteCompany(Long id) {
		companyRepository.deleteById(id);
	}

	public Company editCompany(Company company) {
		if(findById(company.getId()) == null)
			return null;
		Company updatedCompany = companyRepository.save(company);
		return updatedCompany;
		
	}
	
	public Company addIpoToCompany(Long id, Ipo ipo) {
		
		Company company = companyRepository.findById(id).get();
		if(company == null)
			return null;
		
		company.setIpo(ipo);
		ipo.setCompany(company);
		iporepo.save(ipo);
		company = companyRepository.save(company);
		return company;
	}
	
	
	
	
	
}
