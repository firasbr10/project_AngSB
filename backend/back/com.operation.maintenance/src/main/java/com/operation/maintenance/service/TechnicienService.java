package com.operation.maintenance.service;

import com.operation.maintenance.pojo.Technicien;
import java.util.List;

public interface TechnicienService {
    Technicien ajouterTechnicien(Technicien technicien);
    Technicien mettreAJourTechnicien( Technicien technicien);
    void supprimerTechnicien(Long id);
    Technicien obtenirTechnicien(Long id); 
    List<Technicien> obtenirTousLesTechniciens();
	boolean authenticate(String username, String password);   
    
    
    
}
