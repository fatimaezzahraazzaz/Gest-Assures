package model;

public class Reclamation {
    private int id;
    private String description;
    private java.sql.Date dateReclamation;
    private String numeroSecSoc;
    private String nom;
    private String prenom;

    // Getters et setters pour les champs

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public java.sql.Date getDateReclamation() {
        return dateReclamation;
    }

    public void setDateReclamation(java.sql.Date dateReclamation) {
        this.dateReclamation = dateReclamation;
    }

   

    public String getNumeroSecSoc() {
		return numeroSecSoc;
	}

	public void setNumeroSecSoc(String numeroSecSoc) {
		this.numeroSecSoc = numeroSecSoc;
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
}
