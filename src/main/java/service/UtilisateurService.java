package service;

import dao.UtilisateurDAO;
import dao.impl.UtilisateurDAOImpl;
import model.Assure;
import model.Utilisateur;

import java.sql.SQLException;
import java.util.List;

public class UtilisateurService {
    private UtilisateurDAO utilisateurDAO;

    public UtilisateurService() {
        utilisateurDAO = new UtilisateurDAOImpl();
    }

    public void addUtilisateur(Utilisateur utilisateur) {
        utilisateurDAO.addUtilisateur(utilisateur);
    }

    public void updateUtilisateur(Utilisateur utilisateur) {
        utilisateurDAO.updateUtilisateur(utilisateur);
    }

    public void deleteUtilisateur(int id) {
        utilisateurDAO.deleteUtilisateur(id);
    }

    public Utilisateur getUtilisateurById(int id) {
        return utilisateurDAO.getUtilisateurById(id);
    }

    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurDAO.getAllUtilisateurs();
    }
    public Utilisateur getUtilisateurByNumeroSecSoc(String numeroSecSoc) {
        return utilisateurDAO.getUtilisateurByNumeroSecSoc(numeroSecSoc);
    }

    public Utilisateur getUtilisateurByUsername(String username) {
        return utilisateurDAO.getUtilisateurByUsername(username);
    }
    public Utilisateur authenticate(String username, String password) {
        Utilisateur utilisateur = getUtilisateurByUsername(username);
        if (utilisateur != null && utilisateur.getPassword().equals(password)) {
            // Récupérer l'objet Assure associé à l'utilisateur
            Assure assure = utilisateur.getAssure();
            if (assure != null) {
                // Si l'objet Assure existe, le définir dans l'utilisateur
                utilisateur.setAssure(assure);
            }
            return utilisateur; // Retourne l'utilisateur authentifié avec l'objet Assure
        } else {
            return null; // Retourne null si l'authentification échoue
        }
    }
    
    public boolean isNumeroSecuExists(String numeroSecu) throws SQLException {
        return utilisateurDAO.isNumeroSecuExists(numeroSecu);
    }
   

}
