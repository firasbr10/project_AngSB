package com.operation.maintenance.pojo;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "interventions")
public class Intervention {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "equipement_id")
    private Equipement equipement;

    @ManyToOne
    @JoinColumn(name = "technicien_id")
    private Technicien technicien;

    private String statut;

    @Temporal(TemporalType.DATE)
    private Date date;

    private Double cout;

    // Constructeurs
    public Intervention() {}

    public Intervention(Long id, Equipement equipement, Technicien technicien, String statut, Date date, Double cout) {
        this.id = id;
        this.equipement = equipement;
        this.technicien = technicien;
        this.statut = statut;
        this.date = date;
        this.cout = cout;
    }

    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Equipement getEquipement() { return equipement; }
    public void setEquipement(Equipement equipement) { this.equipement = equipement; }

    public Technicien getTechnicien() { return technicien; }
    public void setTechnicien(Technicien technicien) { this.technicien = technicien; }

    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public Double getCout() { return cout; }
    public void setCout(Double cout) { this.cout = cout; }
}
