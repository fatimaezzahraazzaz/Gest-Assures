package service;

import java.util.List;
import dao.ReclamationDAO;
import dao.impl.ReclamationDAOImpl;
import model.Reclamation;

public class ReclamationService {
    private ReclamationDAO reclamationDAO;

    public ReclamationService() {
        reclamationDAO = new ReclamationDAOImpl();
    }

    public void ajouterReclamation(Reclamation reclamation) {
        reclamationDAO.ajouterReclamation(reclamation);
    }

    public void modifierReclamation(Reclamation reclamation) {
        reclamationDAO.modifierReclamation(reclamation);
    }

    public void supprimerReclamation(int id) {
        reclamationDAO.supprimerReclamation(id);
    }

    public List<Reclamation> getReclamationsParNumeroSecSoc(String numeroSecSoc) {
        return reclamationDAO.getReclamationsParNumeroSecSoc(numeroSecSoc);
    }

    public List<Reclamation> getAllReclamations() {
        return reclamationDAO.getAllReclamations();
    }
    public Reclamation getReclamationById(int id) {
        // Utilisez votre DAO pour récupérer la réclamation par son ID
        return reclamationDAO.getReclamationById(id);
    }
    public int getTotalReclamation() {
	    return reclamationDAO.getTotalReclamation();
	    }


}
