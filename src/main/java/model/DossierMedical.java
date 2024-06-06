package model;

public class DossierMedical {
    private int id;
    private String numeroSecu;
    private String groupeSanguin;
    private String allergies;
    private String antecedentsMedicaux;
    private String listeMedicamentsPrescrits;

    public DossierMedical() {}

    public DossierMedical(String numeroSecu, String groupeSanguin, String allergies, String antecedentsMedicaux, String listeMedicamentsPrescrits) {
        this.numeroSecu = numeroSecu;
        this.groupeSanguin = groupeSanguin;
        this.allergies = allergies;
        this.antecedentsMedicaux = antecedentsMedicaux;
        this.listeMedicamentsPrescrits = listeMedicamentsPrescrits;
    }

    public DossierMedical(int id, String numeroSecu, String groupeSanguin, String allergies, String antecedentsMedicaux, String listeMedicamentsPrescrits) {
        this.id = id;
        this.numeroSecu = numeroSecu;
        this.groupeSanguin = groupeSanguin;
        this.allergies = allergies;
        this.antecedentsMedicaux = antecedentsMedicaux;
        this.listeMedicamentsPrescrits = listeMedicamentsPrescrits;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroSecu() {
        return numeroSecu;
    }

    public void setNumeroSecu(String numeroSecu) {
        this.numeroSecu = numeroSecu;
    }

    public String getGroupeSanguin() {
        return groupeSanguin;
    }

    public void setGroupeSanguin(String groupeSanguin) {
        this.groupeSanguin = groupeSanguin;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getAntecedentsMedicaux() {
        return antecedentsMedicaux;
    }

    public void setAntecedentsMedicaux(String antecedentsMedicaux) {
        this.antecedentsMedicaux = antecedentsMedicaux;
    }

    public String getListeMedicamentsPrescrits() {
        return listeMedicamentsPrescrits;
    }

    public void setListeMedicamentsPrescrits(String listeMedicamentsPrescrits) {
        this.listeMedicamentsPrescrits = listeMedicamentsPrescrits;
    }
}
