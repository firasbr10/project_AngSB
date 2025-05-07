package com.operation.maintenance.pojo;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "equipements")
public class Equipement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String etat;

    @Temporal(TemporalType.DATE)
    private Date dateAcquisition;

    // Constructeurs
    public Equipement() {}

    public Equipement(Long id, String nom, String etat, Date dateAcquisition) {
        this.id = id;
        this.nom = nom;
        this.etat = etat;
        this.dateAcquisition = dateAcquisition;
    }

    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getEtat() { return etat; }
    public void setEtat(String etat) { this.etat = etat; }

    public Date getDateAcquisition() { return dateAcquisition; }
    public void setDateAcquisition(Date dateAcquisition) { this.dateAcquisition = dateAcquisition; }
}
