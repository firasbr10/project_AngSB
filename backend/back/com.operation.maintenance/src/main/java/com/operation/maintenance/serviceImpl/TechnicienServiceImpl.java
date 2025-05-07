package com.operation.maintenance.serviceImpl;

import com.operation.maintenance.dao.TechnicienDAO;
import com.operation.maintenance.dao.TechnicienRepository;
import com.operation.maintenance.pojo.Technicien;
import com.operation.maintenance.service.TechnicienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class TechnicienServiceImpl implements TechnicienService {

    @Autowired
    private TechnicienDAO technicienDAO;
    
    @Autowired
    private TechnicienRepository technicienRepository;

    @Transactional
    @Override
    public Technicien ajouterTechnicien(Technicien technicien) {
        return technicienDAO.save(technicien);
    }

    @Transactional
    @Override
    public Technicien mettreAJourTechnicien(Technicien technicien) {
        return technicienDAO.save(technicien);
    }

    @Transactional
    @Override
    public void supprimerTechnicien(Long id) {
        technicienDAO.deleteById(id);
    }

    
    @Override
    public Technicien obtenirTechnicien(Long id) {
        return technicienDAO.findById(id).orElse(null);
    }

    @Override
    public List<Technicien> obtenirTousLesTechniciens() {
        return technicienDAO.findAll();
    }
    
    @Override
    public boolean authenticate(String username, String password) {
        Technicien technicien = technicienRepository.findByUsername(username);
        if (technicien != null) {
            return technicien.getPassword().equals(password); 
        }
        return false;
    }
    
    
}
