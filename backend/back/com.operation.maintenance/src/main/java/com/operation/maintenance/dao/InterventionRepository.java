package com.operation.maintenance.dao;

import com.operation.maintenance.pojo.Intervention;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterventionRepository extends JpaRepository<Intervention, Long> {
	
}
