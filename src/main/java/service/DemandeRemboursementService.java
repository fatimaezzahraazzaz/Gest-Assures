package service;

import dao.DemandeRemboursementDAO;
import dao.impl.DemandeRemboursementDAOImpl;
import model.DemandeRemboursement;
import java.util.List;

public class DemandeRemboursementService {
    private DemandeRemboursementDAO demandeRemboursementDAO = new DemandeRemboursementDAOImpl();

    public void addDemandeRemboursement(DemandeRemboursement demandeRemboursement) {
        demandeRemboursementDAO.addDemandeRemboursement(demandeRemboursement);
    }

    public List<DemandeRemboursement> getAllDemandeRemboursement() {
        return demandeRemboursementDAO.getAllDemandeRemboursement();
    }

    public DemandeRemboursement getDemandeRemboursementById(int id) {
        return demandeRemboursementDAO.getDemandeRemboursementById(id);
    }

    public void updateDemandeRemboursement(DemandeRemboursement demandeRemboursement) {
        demandeRemboursementDAO.updateDemandeRemboursement(demandeRemboursement);
    }

    public void deleteDemandeRemboursement(int id) {
        demandeRemboursementDAO.deleteDemandeRemboursement(id);
    }

    public boolean isNssExists(String nss) {
        return demandeRemboursementDAO.isNssExists(nss);
    }


    // Méthode pour récupérer les demandes de remboursement par NSS
    public List<DemandeRemboursement> getDemandesRemboursementByNSS(String nss) {
        return demandeRemboursementDAO.getDemandesRemboursementByNSS(nss);
    }
    public int getTotalCotisation() {
        return demandeRemboursementDAO.getTotalDemande();
    }
}
