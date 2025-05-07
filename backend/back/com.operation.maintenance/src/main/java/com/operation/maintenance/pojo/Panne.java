package com.operation.maintenance.pojo;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pannes")
public class Panne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private String categorie;

    @ManyToOne
    @JoinColumn(name = "equipement_id")
    private Equipement equipement;

    @Temporal(TemporalType.DATE)
    private Date dateSignalement;

    // Constructeurs
    public Panne() {}

    public Panne(Long id, String description, String categorie, Equipement equipement, Date dateSignalement) {
        this.id = id;
        this.description = description;
        this.categorie = categorie;
        this.equipement = equipement;
        this.dateSignalement = dateSignalement;
    }

    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getCategorie() { return categorie; }
    public void setCategorie(String categorie) { this.categorie = categorie; }

    public Equipement getEquipement() { return equipement; }
    public void setEquipement(Equipement equipement) { this.equipement = equipement; }

    public Date getDateSignalement() { return dateSignalement; }
    public void setDateSignalement(Date dateSignalement) { this.dateSignalement = dateSignalement; }
}
