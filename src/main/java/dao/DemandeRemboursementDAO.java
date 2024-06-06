package dao;

import java.util.List;
import model.DemandeRemboursement;

public interface DemandeRemboursementDAO {
    void addDemandeRemboursement(DemandeRemboursement demandeRemboursement);
    List<DemandeRemboursement> getAllDemandeRemboursement();
    DemandeRemboursement getDemandeRemboursementById(int id);
    void updateDemandeRemboursement(DemandeRemboursement demandeRemboursement);
    void deleteDemandeRemboursement(int id);
	boolean isNssExists(String nss);
	List<DemandeRemboursement> getDemandesRemboursementByNSS(String nss);
	int getTotalDemande() ;

}
