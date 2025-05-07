package com.operation.maintenance.restImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.operation.maintenance.pojo.Technicien;
import com.operation.maintenance.service.TechnicienService;

import java.util.List;

//@RestController
@RequestMapping("/api/techniciens")
public class TechnicienControllerImpl {

    @Autowired
    private TechnicienService technicienService;

    // Obtenir tous les techniciens
    @GetMapping
    public List<Technicien> getAllTechniciens() {
        return technicienService.obtenirTousLesTechniciens();
    }

    // Obtenir un technicien par son ID
    @GetMapping("/{id}")
    public Technicien getTechnicienById(@PathVariable Long id) {
        return technicienService.obtenirTechnicien(id);
    }

    // Créer un nouveau technicien
    @PostMapping
    public Technicien createTechnicien(@RequestBody Technicien technicien) {
        return technicienService.ajouterTechnicien(technicien); 
    }

    // Mettre à jour un technicien existant
   // @PutMapping("/{id}")
    //public Technicien updateTechnicien(@PathVariable Long id, @RequestBody Technicien technicien) {
      //  return technicienService.mettreAJourTechnicien(id, technicien);
    //}

    // Supprimer un technicien par son ID
    @DeleteMapping("/{id}")
    public void deleteTechnicien(@PathVariable Long id) {
        technicienService.supprimerTechnicien(id);
    }
}

