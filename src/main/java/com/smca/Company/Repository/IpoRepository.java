package com.smca.Company.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smca.Company.Models.Ipo;

@Repository
public interface IpoRepository extends JpaRepository<Ipo, Long> {
	
}
