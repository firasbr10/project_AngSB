package com.operation.maintenance.service;

import com.operation.maintenance.pojo.Panne;
import java.util.List;

public interface PanneService {
    List<Panne> getAllPannes();
    Panne getPanneById(Long id);
    Panne createPanne(Panne panne);
    Panne updatePanne(Long id, Panne panne);
    void deletePanne(Long id);
}
