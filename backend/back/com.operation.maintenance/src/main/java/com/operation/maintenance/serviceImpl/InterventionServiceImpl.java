package com.operation.maintenance.serviceImpl;

import com.operation.maintenance.pojo.Equipement;
import com.operation.maintenance.pojo.Intervention;
import com.operation.maintenance.pojo.Technicien;
import com.operation.maintenance.dao.EquipementRepository;
import com.operation.maintenance.dao.InterventionRepository;
import com.operation.maintenance.dao.TechnicienRepository;
import com.operation.maintenance.service.InterventionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InterventionServiceImpl implements InterventionService {

    @Autowired
    private InterventionRepository interventionRepository;
    
    @Autowired
    private EquipementRepository equipementRepository;

    @Autowired
    private TechnicienRepository technicienRepository;

    @Override
    public List<Intervention> getAllInterventions() {
        return interventionRepository.findAll();
    }

    @Override
    public Intervention getInterventionById(Long id) {
        return interventionRepository.findById(id).orElse(null);
    }

    @Override
    public Intervention createIntervention(Intervention intervention) {
        Long equipementId = intervention.getEquipement().getId();
        Long technicienId = intervention.getTechnicien().getId();

        Equipement equipement = equipementRepository.findById(equipementId).orElse(null);
        Technicien technicien = technicienRepository.findById(technicienId).orElse(null);

        if (equipement != null && technicien != null) {
            intervention.setEquipement(equipement);
            intervention.setTechnicien(technicien);
            return interventionRepository.save(intervention);
        } else {
            throw new RuntimeException("Technicien ou Équipement introuvable !");
        }
    }

    @Override
    public Intervention updateIntervention(Long id, Intervention intervention) {
        Optional<Intervention> optional = interventionRepository.findById(id);
        if (optional.isPresent()) {
            Intervention existing = optional.get();
            existing.setEquipement(intervention.getEquipement());
            existing.setTechnicien(intervention.getTechnicien());
            existing.setStatut(intervention.getStatut());
            existing.setDate(intervention.getDate());
            existing.setCout(intervention.getCout());
            return interventionRepository.save(existing);
        }
        return null;
    }

    @Override
    public void deleteIntervention(Long id) {
        interventionRepository.deleteById(id);
    }
}
