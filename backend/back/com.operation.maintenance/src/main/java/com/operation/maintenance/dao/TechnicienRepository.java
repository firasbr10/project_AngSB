package com.operation.maintenance.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.operation.maintenance.pojo.Technicien;

public interface TechnicienRepository extends JpaRepository<Technicien, Long> {
	
	Technicien findByUsername(String username);
	
}
