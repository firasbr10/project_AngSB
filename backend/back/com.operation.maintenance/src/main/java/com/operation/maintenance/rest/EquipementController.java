package com.operation.maintenance.rest;

import com.operation.maintenance.pojo.Equipement;
import com.operation.maintenance.service.EquipementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/equipements")
public class EquipementController {

    private final EquipementService equipementService;

    @Autowired
    public EquipementController(EquipementService equipementService) {
        this.equipementService = equipementService;
    }

    @PostMapping
    public ResponseEntity<Equipement> createEquipement(@RequestBody Equipement equipement) {
        Equipement createdEquipement = equipementService.saveEquipement(equipement);
        return new ResponseEntity<>(createdEquipement, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Equipement>> getAllEquipements() {
        List<Equipement> equipements = equipementService.getAllEquipements();
        return new ResponseEntity<>(equipements, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipement> getEquipementById(@PathVariable Long id) {
        Optional<Equipement> equipement = equipementService.getEquipementById(id);
        return equipement.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipement> updateEquipement(@PathVariable Long id, @RequestBody Equipement equipement) {
        Equipement updatedEquipement = equipementService.updateEquipement(id, equipement);
        return updatedEquipement != null ?
                new ResponseEntity<>(updatedEquipement, HttpStatus.OK) :
                ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEquipement(@PathVariable Long id) {
        equipementService.deleteEquipement(id);
        return ResponseEntity.noContent().build();
    }
}
