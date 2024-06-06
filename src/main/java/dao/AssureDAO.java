package dao;

import model.Assure;
import java.util.List;

public interface AssureDAO {
    void ajouterAssure(Assure assure);
    void modifierAssure(Assure assure);
    void supprimerAssure(int id);
    boolean isNumeroSecuriteSocialeUnique(String numeroSecuriteSociale);
    boolean isNumeroSecSocUniqueForUpdate(int id, String numeroSecSoc);
    Assure getByNumeroSecSoc(String numeroSecSoc); // Ajout de la nouvelle méthode
    Assure getAssureById(int id);
    boolean isNumeroSecuriteSocialeExiste(String numeroSecuriteSociale);
    List<Assure> getAllAssures();
    int getTotalAssures();
    Assure getAssureDetails(String numeroSecSoc);
    
    
}
