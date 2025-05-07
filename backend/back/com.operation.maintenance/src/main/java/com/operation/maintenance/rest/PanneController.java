package com.operation.maintenance.rest;

import com.operation.maintenance.pojo.Panne;
import com.operation.maintenance.service.PanneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pannes")
public class PanneController {

    @Autowired
    private PanneService panneService;

    // GET all Pannes
    @GetMapping
    public List<Panne> getAllPannes() {
        return panneService.getAllPannes();
    }

    // GET Panne by ID
    @GetMapping("/{id}")
    public ResponseEntity<Panne> getPanneById(@PathVariable Long id) {
        Panne panne = panneService.getPanneById(id);
        if (panne == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(panne);
    }

    // POST create Panne
    @PostMapping
    public ResponseEntity<Panne> createPanne(@RequestBody Panne panne) {
        Panne createdPanne = panneService.createPanne(panne);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPanne);
    }

    // PUT update Panne
    @PutMapping("/{id}")
    public ResponseEntity<Panne> updatePanne(@PathVariable Long id, @RequestBody Panne panne) {
        Panne updatedPanne = panneService.updatePanne(id, panne);
        if (updatedPanne == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(updatedPanne);
    }

    // DELETE Panne
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePanne(@PathVariable Long id) {
        panneService.deletePanne(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
