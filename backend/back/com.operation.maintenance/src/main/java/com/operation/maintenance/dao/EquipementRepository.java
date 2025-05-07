package com.operation.maintenance.dao;

import com.operation.maintenance.pojo.Equipement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipementRepository extends JpaRepository<Equipement, Long> {
    
}
