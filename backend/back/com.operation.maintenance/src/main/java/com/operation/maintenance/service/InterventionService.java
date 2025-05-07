package com.operation.maintenance.service;

import com.operation.maintenance.pojo.Intervention;
import java.util.List;

public interface InterventionService {
    List<Intervention> getAllInterventions();
    Intervention getInterventionById(Long id);
    Intervention createIntervention(Intervention intervention);
    Intervention updateIntervention(Long id, Intervention intervention);
    void deleteIntervention(Long id);
}
