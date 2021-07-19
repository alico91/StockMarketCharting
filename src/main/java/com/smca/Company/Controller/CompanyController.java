package com.smca.Company.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smca.Company.Models.Company;
import com.smca.Company.Models.IPODetail;
import com.smca.Company.Services.CompanyService;

@RestController
@CrossOrigin(origins= "http://localhost:4200")
@RequestMapping("/company-service/companies")
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	@GetMapping(path = "")
	public ResponseEntity<List<Company>> getCompanies(){
		return ResponseEntity
				.ok(companyService.getCompanies());
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Company> getCompanyDetails(@PathVariable Long id) {
		Company company = companyService.findById(id);
		return ResponseEntity.ok(company);
	}
	
	@GetMapping(path = "/{id}/ipos")
	public ResponseEntity<IPODetail> getCompanyIpoDetails(@PathVariable Long id){
		IPODetail ipoDetail = companyService.getCompanyIpoDetails(id);
		return ResponseEntity.ok(ipoDetail);
	}
	
	
	@PostMapping(path = "")
	public ResponseEntity<?> addCompany(@RequestBody Company company) {
		return ResponseEntity.ok(companyService.addCompany(company));
	}
	
	@DeleteMapping(path = "/{id}")
	public void deleteCompany(@PathVariable Long id) {
		companyService.deleteCompany(id);
	}
	
	@PutMapping(path = "")
	public ResponseEntity<Company> editCompany(@RequestBody Company company){
		Company updatedCompany = companyService.editCompany(company);
		return ResponseEntity.ok(updatedCompany);
	}
	
	@PostMapping(path = "/{companyName}/ipos")
	public void addIpoToCompany(@PathVariable String companyName, @RequestBody IPODetail ipo)
		
	{
		Company company = companyService.addIpoToCompany(companyName, ipo);
		/*if(company == null) {
			throw new CompanyException("Company not with name : " + companyName);
		}*/
	}
	
}
