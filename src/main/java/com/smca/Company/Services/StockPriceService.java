package com.smca.Company.Services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smca.Company.Dto.CompanyCompareRequest;
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
	
	public List<StockPrice> findAll() {
		List<StockPrice> stockPrices = stockPriceRepository.findAll();
		return stockPrices;
	}

	public StockPrice findById(Long id) {
		Optional<StockPrice> stockPrice = stockPriceRepository.findById(id);
		if(!stockPrice.isPresent())
			return null;
		return stockPrice.get();
	}
	
	public List<StockPrice> getStockPricesForCompanyComparison(CompanyCompareRequest compareRequest) throws ParseException{
		Date fromDate = new SimpleDateFormat("dd-MM-yyyy").parse(compareRequest.getFromPeriod());
		Date toDate = new SimpleDateFormat("dd-MM-yyyy").parse(compareRequest.getToPeriod());
		List<StockPrice> stockPrices = stockPriceRepository
				.findByCompanyCodeAndExchangeName(compareRequest.getCompanyCode(), compareRequest.getStockExchangeName());
		List<StockPrice> filteredList = stockPrices.stream()
				.filter(stockPrice -> {
					Date date = null;
					try {
						date = new SimpleDateFormat("dd-MM-yyyy").parse(stockPrice.getDate());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					return date.after(fromDate) && date.before(toDate);
				})
				.collect(Collectors.toList());
		return filteredList;
	}
}
