package com.smca.Company.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smca.Company.Models.Company;
import com.smca.Company.Models.Sector;
import com.smca.Company.Services.SectorService;

@RestController
@RequestMapping("/sector-service/sectors")
public class SectorController {
	
	@Autowired
	private SectorService sectorService;
	
	@GetMapping(path = "")
	public ResponseEntity<List<Sector>> getSectors(){
		return ResponseEntity
				.ok(sectorService.getSector());
	}
	
	@PostMapping(path = "")
	public ResponseEntity<?> addSector(Sector sector) {
		return ResponseEntity.ok(sectorService.addSector(sector));
	}
	
}
