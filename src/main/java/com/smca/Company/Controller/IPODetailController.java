package com.smca.Company.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smca.Company.Models.IPODetail;
import com.smca.Company.Services.IPODetailService;


@RestController
@RequestMapping("/ipos")
public class IPODetailController {
	
	@Autowired
	private IPODetailService ipoService;
	
	@GetMapping(path = "")
	public ResponseEntity<List<IPODetail>> findAll() {
		return ResponseEntity.ok(ipoService.findAll());
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<IPODetail> findById(@PathVariable Long id){
		IPODetail ipoDetail = ipoService.findById(id);
		return ResponseEntity.ok(ipoDetail);
	}
	
	@PostMapping(path = "")
	public ResponseEntity<IPODetail> save(@RequestBody IPODetail ipo){
		IPODetail addedIpo = ipoService.save(ipo);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(addedIpo);
	}
	
	@PutMapping(path = "")
	public ResponseEntity<IPODetail> update(@RequestBody IPODetail ipo){
		IPODetail updatedIpo = ipoService.update(ipo);
		return ResponseEntity.ok(updatedIpo);
	}
	
	@DeleteMapping(path = "/{id}")
	public void deleteById(@PathVariable Long id) {
		ipoService.deleteById(id);
	}
}
