package com.operation.maintenance.dao;

import com.operation.maintenance.pojo.Panne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PanneRepository extends JpaRepository<Panne, Long> {
	
}
