package service;

import java.util.List;

import dao.CotisationDAO;
import dao.impl.CotisationDAOImpl;
import model.Cotisation;

public class CotisationService {
    private CotisationDAO cotisationDAO;

    public CotisationService() {
        this.cotisationDAO = new CotisationDAOImpl();
    }

    public void addCotisation(Cotisation cotisation) {
        cotisationDAO.addCotisation(cotisation);
    }

    public void updateCotisation(Cotisation cotisation) {
        cotisationDAO.updateCotisation(cotisation);
    }

    public void deleteCotisation(int cotisationId) {
        cotisationDAO.deleteCotisation(cotisationId);
    }

    public Cotisation getCotisationById(int cotisationId) {
        return cotisationDAO.getCotisationById(cotisationId);
    }

    public List<Cotisation> getAllCotisations() {
        return cotisationDAO.getAllCotisations();
    }
    public boolean numeroSecSocExists(String numeroSecSoc) {
        return cotisationDAO.numeroSecSocExists(numeroSecSoc);
    }

	// Méthode pour récupérer les cotisations par numéro de sécurité sociale
    public List<Cotisation> getCotisationsByNumeroSecSoc(String numeroSecSoc) {
        return cotisationDAO.getCotisationsByNumeroSecSoc(numeroSecSoc);
    }
    public double getTotalCotisation() {
        return cotisationDAO.getTotalCotisation();
    }
    
}
