package com.operation.maintenance.dao.impl;

import com.operation.maintenance.dao.TechnicienDAO;
import com.operation.maintenance.pojo.Technicien;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class TechnicienDAOImpl implements TechnicienDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Technicien save(Technicien technicien) {
        if (technicien.getId() == null) {
            entityManager.persist(technicien); 
            return technicien;
        } else {
            return entityManager.merge(technicien); 
        }
        
    }

    @Override
    public Optional<Technicien> findById(Long id) {
        Technicien t = entityManager.find(Technicien.class, id);
        return Optional.ofNullable(t);
    }

    @Override
    public List<Technicien> findAll() {
        return entityManager.createQuery("FROM Technicien", Technicien.class).getResultList();
    }

    @Override
    public void deleteById(Long id) {
        Technicien t = entityManager.find(Technicien.class, id);
        if (t != null) {
            entityManager.remove(t);
        }
    }

    @Override
    public Technicien update(Technicien technicien) {
        return entityManager.merge(technicien);
    }
}
