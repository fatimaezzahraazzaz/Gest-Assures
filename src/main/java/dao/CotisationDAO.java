package dao;

import java.util.List;
import model.Cotisation;

public interface CotisationDAO {
    // Méthode pour ajouter une cotisation
    void addCotisation(Cotisation cotisation);

    // Méthode pour supprimer une cotisation par son ID
    void deleteCotisation(int cotisationId);

    // Méthode pour mettre à jour une cotisation
    void updateCotisation(Cotisation cotisation);

    // Méthode pour récupérer toutes les cotisations
    List<Cotisation> getAllCotisations();

    // Méthode pour récupérer une cotisation par son ID
    Cotisation getCotisationById(int cotisationId);
    boolean numeroSecSocExists(String numeroSecSoc);

	List<Cotisation> getCotisationsByNumeroSecSoc(String numeroSecSoc);
	
	double getTotalCotisation() ;
	
}
