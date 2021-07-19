package com.smca.Company.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.smca.Company.Models.IPODetail;
import com.smca.Company.Repository.IPODetailRepository;

@Service
public class IPODetailService {
	
	@Autowired
	IPODetailRepository ipoRepository;
	

	public List<IPODetail> findAll() {
		List<IPODetail> ipos = ipoRepository.findAll();
		return ipos;
	}

	
	public IPODetail findById(Long id) {
		IPODetail ipo = ipoRepository.getById(id);
		return ipo;
	}

	public IPODetail save(IPODetail ipo) {
		IPODetail ipoDetail = ipoRepository.save(ipo);
		return ipoDetail;
	}

	public IPODetail update(IPODetail ipo) {
		if(findById(ipo.getIpoId()) == null) {
			return null;
		}
		IPODetail updatedIpo = ipoRepository.save(ipo);
		return updatedIpo;
	}


	public void deleteById(Long id) {
		ipoRepository.deleteById(id);
		
	}
	
	
}
