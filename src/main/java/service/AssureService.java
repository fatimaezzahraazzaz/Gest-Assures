package service;

import dao.AssureDAO;
import dao.impl.AssureDAOImpl;
import model.Assure;

import java.util.List;

public class AssureService {
    private AssureDAO assureDAO;

    public AssureService() {
        this.assureDAO = new AssureDAOImpl();
    }
    
    public boolean isNumeroSecuriteSocialeUnique(String numeroSecuriteSociale) {
        return assureDAO.isNumeroSecuriteSocialeUnique(numeroSecuriteSociale);
    }

    public void ajouterAssure(Assure assure) throws Exception {
        if (!isNumeroSecuriteSocialeUnique(assure.getNumeroSecSoc())) {
            throw new Exception("Numéro de Sécurité Sociale déjà utilisé.");
        }
        assureDAO.ajouterAssure(assure);
    }
    public void modifierAssure(Assure assure) {
        assureDAO.modifierAssure(assure);
    }

    public void supprimerAssure(int id) {
        assureDAO.supprimerAssure(id);
    }
    public boolean isNumeroSecuriteSocialeExiste(String numeroSecuriteSociale) {
        return assureDAO.isNumeroSecuriteSocialeExiste(numeroSecuriteSociale);
    }

    public Assure getAssureById(int id) {
        return assureDAO.getAssureById(id);
    }

    public List<Assure> getAllAssures() {
        return assureDAO.getAllAssures();
    }

	public Assure getByNumeroSecSoc(String numeroSecu) {
		return assureDAO.getByNumeroSecSoc(numeroSecu);
	
	}
	public int getTotalAssures() {
	    return assureDAO.getTotalAssures();
	    }
	 public Assure getAssureDetails(String numeroSecSoc) {
	        return assureDAO.getAssureDetails(numeroSecSoc);
	    }
}
