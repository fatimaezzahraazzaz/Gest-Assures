package model;

import java.util.Date;

public class Cotisation {
    private int id;
    private String numeroSecSoc; // Modifier idAssure en numeroSecSoc
    private double montant;
    private Date datePaiement;
    private String typeCotisation; // Le type de cotisation (par exemple, retraite, assurance maladie, etc.)

    public String getTypeCotisation() {
		return typeCotisation;
	}

	public void setTypeCotisation(String typeCotisation) {
		this.typeCotisation = typeCotisation;
	}

	public Cotisation() {
    }

    public Cotisation(String numeroSecSoc, double montant, Date datePaiement,String typeCotisation) {
        this.numeroSecSoc = numeroSecSoc;
        this.montant = montant;
        this.datePaiement = datePaiement;
        this.typeCotisation = typeCotisation;
    }

    public Cotisation(int id, String numeroSecSoc, double montant, Date datePaiement,String typeCotisation) {
        this.id = id;
        this.numeroSecSoc = numeroSecSoc;
        this.montant = montant;
        this.datePaiement = datePaiement;
        this.typeCotisation = typeCotisation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroSecSoc() {
        return numeroSecSoc;
    }

    public void setNumeroSecSoc(String numeroSecSoc) {
        this.numeroSecSoc = numeroSecSoc;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Date getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(Date datePaiement) {
        this.datePaiement = datePaiement;
    }
}
