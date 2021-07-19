package com.smca.Company.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.smca.Company.Models.Company;
import com.smca.Company.Models.Sector;
import com.smca.Company.Repository.SectorRepository;

@Service
public class SectorService {
	
	@Autowired
	SectorRepository sectorRepository;

	public List<Sector> findAll() {
		List<Sector> sectors=sectorRepository.findAll();
		return sectors;
	}

	public Sector findById(long id) {
		// TODO Auto-generated method stub
		Optional<Sector>sector =sectorRepository.findById(id);
		if(!sector.isPresent())
		   return null;
		return sector.get();
	}

	public Sector save(Sector sector) {
		sectorRepository.save(sector);
		return sector;
	}
	
	public void deleteById(long id) {
		sectorRepository.deleteById(id);
		
	}

	public List<Company> getCompanies(long id) {
		Optional<Sector> sector = sectorRepository.findById(id);
		List<Company> companies = sector.get().getCompanies();
		return companies;
	}

	public Sector addCompanyToSector(String sectorName, Company company) {
		Sector sector = sectorRepository.findByName(sectorName);
		if(sector == null)
			return null;
		sector.getCompanies().add(company);
		sector = sectorRepository.save(sector);
		return sector;
	}
	
	
	
}
