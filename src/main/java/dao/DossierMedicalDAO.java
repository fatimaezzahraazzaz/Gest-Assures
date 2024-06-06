package dao;

import model.DossierMedical;

import java.sql.SQLException;
import java.util.List;

public interface DossierMedicalDAO {
    DossierMedical getById(int id);
    List<DossierMedical> getByNumeroSecu(String numeroSecu);
    List<DossierMedical> getAllDossiersMedicaux();
    void insertDossierMedical(DossierMedical dossierMedical);
    void updateDossierMedical(DossierMedical dossierMedical);
    void deleteDossierMedical(int id);
    
	
}
