package com.smca.Company.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.smca.Company.Models.Company;
import com.smca.Company.Models.CompanyStockExchangeMap;
import com.smca.Company.Models.StockExchange;
import com.smca.Company.Repository.CompanyRepository;
import com.smca.Company.Repository.CompanyStockExchangeMapRepository;
import com.smca.Company.Repository.StockExchangeRepository;

@RestController
@CrossOrigin("http:localhost:4200")
public class CompanyStockExchangeController {
	
	@Autowired
	CompanyStockExchangeMapRepository compstkmaprepo;
	@Autowired
	CompanyRepository cmprepo;
	@Autowired
	StockExchangeRepository stkrepo;
	
	@PostMapping(path="/mapcompanycode")
	public CompanyStockExchangeMap mapcode(@RequestBody CompanyStockExchangeMap cmpstkmap) {
		
		Company company=cmprepo.findByName(cmpstkmap.getCompanyName());
		StockExchange stkexchg=stkrepo.findByName(cmpstkmap.getStockExchangeName());
		CompanyStockExchangeMap csemap = new CompanyStockExchangeMap();
		csemap.setCompanyCode(cmpstkmap.getCompanyCode());
		csemap.setCompany(company);
		csemap.setCompanyName(cmpstkmap.getCompanyName());
		csemap.setStockexchange(stkexchg);
		csemap.setStockExchangeName(cmpstkmap.getStockExchangeName());
		compstkmaprepo.save(csemap);
		return csemap;
	}
}
