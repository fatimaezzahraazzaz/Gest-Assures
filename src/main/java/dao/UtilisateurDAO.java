package dao;

import model.Utilisateur;

import java.sql.SQLException;
import java.util.List;

public interface UtilisateurDAO {
    void addUtilisateur(Utilisateur utilisateur);
    void updateUtilisateur(Utilisateur utilisateur);
    void deleteUtilisateur(int id);
    Utilisateur getUtilisateurById(int id);
    List<Utilisateur> getAllUtilisateurs();
    Utilisateur getUtilisateurByUsername(String username);
    Utilisateur getUtilisateurByNumeroSecSoc(String numeroSecSoc); // Nouvelle méthode pour récupérer un utilisateur par son numéro de sécurité sociale
    boolean isNumeroSecuExists(String numeroSecu) throws SQLException;
}
