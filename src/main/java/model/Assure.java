package model;

import java.sql.Date;

public class Assure {
    private int id;
    private String numeroSecSoc;
    private String nom;
    private String prenom;
    private String adresse;
    private Date dateNaissance;
  
    
  
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNumeroSecSoc() {
		return numeroSecSoc;
	}
	public void setNumeroSecSoc(String numeroSecSoc) {
		this.numeroSecSoc = numeroSecSoc;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

    
}
