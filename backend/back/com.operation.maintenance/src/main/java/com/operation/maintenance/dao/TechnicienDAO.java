package com.operation.maintenance.dao;

import com.operation.maintenance.pojo.Technicien;
import java.util.List;
import java.util.Optional;

public interface TechnicienDAO {
    Technicien save(Technicien technicien);
    Optional<Technicien> findById(Long id);
    List<Technicien> findAll();
    void deleteById(Long id);
    Technicien update(Technicien technicien);
}
