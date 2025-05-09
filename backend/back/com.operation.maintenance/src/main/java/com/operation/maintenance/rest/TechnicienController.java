package com.operation.maintenance.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.operation.maintenance.pojo.Technicien;
import com.operation.maintenance.service.TechnicienService;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/techniciens")
@CrossOrigin(origins = "http://localhost:4200")
public class TechnicienController {

    @Autowired
    private TechnicienService technicienService;

    
    @GetMapping
    public List<Technicien> getAllTechniciens() {
        return technicienService.obtenirTousLesTechniciens();
    }

    
    @GetMapping("/{id}")
    public Technicien getTechnicienById(@PathVariable Long id) {
        return technicienService.obtenirTechnicien(id);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public Technicien createTechnicien(@Valid @RequestBody Technicien technicien) {
        return technicienService.ajouterTechnicien(technicien);
    }
    
    @PutMapping("/{id}")
    public Technicien updateTechnicien(@PathVariable Long id, @RequestBody Technicien technicien) {
        technicien.setId(id); 
        return technicienService.mettreAJourTechnicien(technicien);
    }
    
 
    //@PutMapping("/{id}")
    //public Technicien updateTechnicien(@PathVariable Long id, @RequestBody Technicien technicien) {
     //   return technicienService.mettreAJourTechnicien(id, technicien);  
    //}

    // Supprimer un technicien par son ID
    @DeleteMapping("/{id}")
    public void deleteTechnicien(@PathVariable Long id) {
        technicienService.supprimerTechnicien(id);
    }
     
}
