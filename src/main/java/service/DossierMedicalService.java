package service;

import java.sql.SQLException;
import java.util.List;

import dao.DossierMedicalDAO;
import model.DossierMedical;

public class DossierMedicalService {
    private DossierMedicalDAO dossierMedicalDAO;

    // Constructor for dependency injection
    public DossierMedicalService(DossierMedicalDAO dossierMedicalDAO) {
        this.dossierMedicalDAO = dossierMedicalDAO;
    }

    public DossierMedical getById(int id) {
        return dossierMedicalDAO.getById(id);
    }

    public List<DossierMedical> getByNumeroSecu(String numeroSecu) {
        return dossierMedicalDAO.getByNumeroSecu(numeroSecu);
    }

    public void insert(DossierMedical dossierMedical) {
        dossierMedicalDAO.insertDossierMedical(dossierMedical);
    }

    public void update(DossierMedical dossierMedical) {
        dossierMedicalDAO.updateDossierMedical(dossierMedical);
    }

    public void delete(int id) {
        dossierMedicalDAO.deleteDossierMedical(id);
    }
    
}
