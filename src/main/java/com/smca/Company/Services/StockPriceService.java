package com.smca.Company.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smca.Company.Models.Company;
import com.smca.Company.Models.CompanyStockExchangeMap;
import com.smca.Company.Models.StockPrice;
import com.smca.Company.Repository.CompanyRepository;
import com.smca.Company.Repository.CompanyStockExchangeMapRepository;
import com.smca.Company.Repository.StockPriceRepository;

@Service
public class StockPriceService {
	
	@Autowired
	private StockPriceRepository stockPriceRepository;
	
	@Autowired
	private CompanyStockExchangeMapRepository csemrepo;
	
	@Autowired
	private CompanyRepository companyrepo;
	
	public List<StockPrice> save(List<StockPrice> stockPrices){
		List<StockPrice> updatedsp = new ArrayList();
		for(int i=0;i<stockPrices.size();i++) {
			StockPrice stockprice = stockPrices.get(i);
			CompanyStockExchangeMap csemap = csemrepo.findByCompanyCode(stockprice.getCompanyCode());
			Company company = companyrepo.findByName(csemap.getCompanyName());
			stockprice.setCompany(company);
		    StockPrice stkprice= stockPriceRepository.save(stockprice);
		    updatedsp.add(stkprice);	
		}
		
		return updatedsp;
	}
}
