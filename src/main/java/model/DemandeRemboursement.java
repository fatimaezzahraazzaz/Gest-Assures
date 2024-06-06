package model;

import java.sql.Date;

// Importez la classe Statut depuis son package
import model.Statut;

public class DemandeRemboursement {
    private int id;
    private String nss;
    private double montant;
    private String motif;
    private Statut statut;
    private Date dateDemande;

 // Constructeur
    public DemandeRemboursement(int id, String nss, double montant, String motif, Statut statut, Date dateDemande) {
        this.id = id;
        this.nss = nss;
        this.montant = montant;
        this.motif = motif;
        this.statut = statut;
        this.dateDemande = dateDemande;
    }

    // Autre constructeur
    public DemandeRemboursement(String nss, double montant, String motif, Statut statut, Date dateDemande) {
        this.nss = nss;
        this.montant = montant;
        this.motif = motif;
        this.statut = statut;
        this.dateDemande = dateDemande;
    }


    // Getters et setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNss() {
        return nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    public Date getDateDemande() {
        return dateDemande;
    }

    public void setDateDemande(Date dateDemande) {
        this.dateDemande = dateDemande;
    }
}
