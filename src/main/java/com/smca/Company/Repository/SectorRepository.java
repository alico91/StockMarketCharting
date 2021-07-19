package com.smca.Company.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smca.Company.Models.Sector;

@Repository
public interface SectorRepository extends JpaRepository<Sector,Long>{
	public Sector findByName(String name);
}
