package com.operation.maintenance.rest;

import com.operation.maintenance.pojo.Intervention;
import com.operation.maintenance.service.InterventionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/interventions")
public class InterventionController {

    @Autowired
    private InterventionService interventionService;

    @GetMapping
    public List<Intervention> getAllInterventions() {
        return interventionService.getAllInterventions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Intervention> getInterventionById(@PathVariable Long id) {
        Intervention intervention = interventionService.getInterventionById(id);
        return intervention != null ? ResponseEntity.ok(intervention) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Intervention> createIntervention(@RequestBody Intervention intervention) {
        return ResponseEntity.ok(interventionService.createIntervention(intervention));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Intervention> updateIntervention(@PathVariable Long id, @RequestBody Intervention intervention) {
        Intervention updated = interventionService.updateIntervention(id, intervention);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIntervention(@PathVariable Long id) {
        interventionService.deleteIntervention(id);
        return ResponseEntity.noContent().build();
    }
}
