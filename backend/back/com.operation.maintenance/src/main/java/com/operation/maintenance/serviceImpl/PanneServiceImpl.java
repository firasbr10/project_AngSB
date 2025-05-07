package com.operation.maintenance.serviceImpl;

import com.operation.maintenance.pojo.Equipement;
import com.operation.maintenance.pojo.Panne;
import com.operation.maintenance.dao.EquipementRepository;
import com.operation.maintenance.dao.PanneRepository;
import com.operation.maintenance.service.PanneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PanneServiceImpl implements PanneService {

    @Autowired
    private PanneRepository panneRepository;
    @Autowired
    private EquipementRepository equipementRepository;


    @Override
    public List<Panne> getAllPannes() {
        return panneRepository.findAll();
    }

    @Override
    public Panne getPanneById(Long id) {
        Optional<Panne> panne = panneRepository.findById(id);
        return panne.orElse(null); 
    }

    @Override
    public Panne createPanne(Panne panne) {
        if (panne.getEquipement() != null && panne.getEquipement().getId() != null) {
            Long equipementId = panne.getEquipement().getId();
            Equipement equipement = equipementRepository.findById(equipementId)
                .orElseThrow(() -> new RuntimeException("Équipement non trouvé avec id : " + equipementId));
            panne.setEquipement(equipement); 
        }
        return panneRepository.save(panne);
    }

    @Override
    public Panne updatePanne(Long id, Panne panne) {
        if (panneRepository.existsById(id)) {
            panne.setId(id);
            return panneRepository.save(panne);
        }
        return null;
    }

    @Override
    public void deletePanne(Long id) {
        panneRepository.deleteById(id);
    }
}
