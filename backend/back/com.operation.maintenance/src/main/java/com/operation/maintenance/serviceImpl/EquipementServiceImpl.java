package com.operation.maintenance.serviceImpl;

import com.operation.maintenance.pojo.Equipement;
import com.operation.maintenance.dao.EquipementRepository;
import com.operation.maintenance.service.EquipementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipementServiceImpl implements EquipementService {

    private final EquipementRepository equipementRepository;

    @Autowired
    public EquipementServiceImpl(EquipementRepository equipementRepository) {
        this.equipementRepository = equipementRepository;
    }

    @Override
    public Equipement saveEquipement(Equipement equipement) {
        return equipementRepository.save(equipement);
    }

    @Override
    public List<Equipement> getAllEquipements() {
        return equipementRepository.findAll();
    }

    @Override
    public Optional<Equipement> getEquipementById(Long id) {
        return equipementRepository.findById(id);
    }

    @Override
    public Equipement updateEquipement(Long id, Equipement equipement) {
        if (equipementRepository.existsById(id)) {
            equipement.setId(id);
            return equipementRepository.save(equipement);
        }
        return null; 
    }

    @Override
    public void deleteEquipement(Long id) {
        equipementRepository.deleteById(id);
    }
}
