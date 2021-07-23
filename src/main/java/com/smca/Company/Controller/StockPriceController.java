package com.smca.Company.Controller;

import java.io.IOException;
import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.smca.Company.Models.Company;
import com.smca.Company.Models.CompanyStockExchangeMap;
import com.smca.Company.Models.StockPrice;
import com.smca.Company.Repository.CompanyRepository;
import com.smca.Company.Repository.CompanyStockExchangeMapRepository;
import com.smca.Company.Repository.StockPriceRepository;

@RestController
@CrossOrigin(origins= "http://localhost:4200")
@RequestMapping("/stockPrices")
public class StockPriceController {

	@Autowired
	StockPriceRepository stkpricerepo;
	
	@Autowired
	CompanyRepository companyrepo;
	
	@Autowired
	CompanyStockExchangeMapRepository csemrepo; 
	
	@RequestMapping(value = "/addstockprices",method=RequestMethod.POST)
	public  ResponseEntity<Object> stockpriceapi(@RequestBody StockPrice stockprice) throws ClassNotFoundException, IOException {
		
		CompanyStockExchangeMap csemap = csemrepo.findByCompanyCode(stockprice.getCompanyCode());
		Company company = companyrepo.findByName(csemap.getCompanyName());
		stockprice.setCompany(company);
	    StockPrice stkprice= stkpricerepo.save(stockprice);
	    System.out.println(stkprice +"check this " +stkprice.getCompanyCode());

	    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(stkprice.getId())
	            .toUri();
	    
	    return ResponseEntity.created(location).build();
	}


	//@CrossOrigin(origins ="http://localhost:3000")
	@RequestMapping(value = "/getstockprices",method=RequestMethod.GET, headers = "Accept=application/json"  )
	public List<StockPrice> getstockprice() throws ClassNotFoundException, IOException {

	    List<StockPrice> stkprice= stkpricerepo.findAll();
	    return stkprice;
	}
	

	    
}
