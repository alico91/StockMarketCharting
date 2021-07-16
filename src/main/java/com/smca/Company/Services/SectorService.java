package com.smca.Company.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smca.Company.Models.Sector;
import com.smca.Company.Repository.SectorRepository;

@Service
public class SectorService {
	
	@Autowired
	SectorRepository sectorRepository;

	public List<Sector> getSector() {
		return sectorRepository.findAll();
	}

	public Object addSector(Sector sector) {
		sectorRepository.save(sector);
		return null;
	}
	
}
