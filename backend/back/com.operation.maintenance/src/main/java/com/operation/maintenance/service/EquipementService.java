package com.operation.maintenance.service;

import com.operation.maintenance.pojo.Equipement;
import java.util.List;
import java.util.Optional;

public interface EquipementService {
    Equipement saveEquipement(Equipement equipement);
    List<Equipement> getAllEquipements();
    Optional<Equipement> getEquipementById(Long id);
    Equipement updateEquipement(Long id, Equipement equipement);
    void deleteEquipement(Long id);
}
