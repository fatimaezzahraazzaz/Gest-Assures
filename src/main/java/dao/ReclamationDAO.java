package dao;

import java.util.List;
import model.Reclamation;

public interface ReclamationDAO {
    // Méthode pour ajouter une réclamation
    public void ajouterReclamation(Reclamation reclamation);

    // Méthode pour modifier une réclamation
    public void modifierReclamation(Reclamation reclamation);

    // Méthode pour supprimer une réclamation
    public void supprimerReclamation(int id);

    // Méthode pour obtenir toutes les réclamations d'un assuré par son numéro de sécurité sociale
    public List<Reclamation> getReclamationsParNumeroSecSoc(String numeroSecSoc);

    // Méthode pour obtenir toutes les réclamations
    public List<Reclamation> getAllReclamations();
    
    public Reclamation getReclamationById(int id);
    int getTotalReclamation();

}
