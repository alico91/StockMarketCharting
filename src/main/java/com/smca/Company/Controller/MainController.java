package com.smca.Company.Controller;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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
import com.smca.Company.Models.StockExchange;
import com.smca.Company.Repository.CompanyRepository;
import com.smca.Company.Repository.CompanyStockExchangeMapRepository;
import com.smca.Company.Repository.StockExchangeRepository;

@CrossOrigin
@RestController
public class MainController {
	
	@Autowired
	CompanyRepository cmprep;
	@Autowired
	StockExchangeRepository stkrep;
	@Autowired
	CompanyStockExchangeMapRepository stkcmpmaprep;
	@Autowired
	EntityManager em;
	
	@RequestMapping(value = "/company", method = RequestMethod.POST)
	public ResponseEntity<Object> createcompany(@RequestBody Company cmp) {
		cmprep.save(cmp);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cmp.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@RequestMapping(value = "/mapcompanycode", method = RequestMethod.POST)
	// pass map of string in requestbody ,instead of pojo class to get
	// non entity based params
//This method maps company to stockmarket	
public String mapcode(@RequestBody Map<String, String> text) {
		System.out.println("params100" + text.get("companyname"));
		Query query = em.createNamedQuery("Company.findByname");
		query.setParameter("name", text.get("companyname"));
		Company c = (Company) query.getSingleResult();

		StockExchange e = stkrep.findByName(text.get("exchangename"));
		CompanyStockExchangeMap cse = new CompanyStockExchangeMap();
		cse.setCompany(c);
		cse.setStockexchange(e);
		stkcmpmaprep.save(cse);
		return "Test";
		// return companyname;
	}
	
	
       // show all  records from companystockexchangemap entity
	@RequestMapping(value = "/listall", method = RequestMethod.GET)	
	public String listit() {
		
		String x = "";
		List<CompanyStockExchangeMap> csem = stkcmpmaprep.findAll();
		for (CompanyStockExchangeMap c:csem)  {
			Optional<StockExchange> s =	stkrep.findById(c.getStockexchange().getId()); 
			Optional<Company> cc =cmprep.findById(c.getCompany().getId());
				x= x + "   "+cc.get().getname() + "   "+s.get().getname(); //getcompany code can be added here
		}
		
		
		
		return x;
		// return companyname;
	}


}
