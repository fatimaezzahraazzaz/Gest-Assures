package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Assure;
import model.Utilisateur;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import dao.AssureDAO;
import dao.UtilisateurDAO;
import dao.impl.AssureDAOImpl;
import dao.impl.UtilisateurDAOImpl;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AssureDAO assureDAO;
    private UtilisateurDAO utilisateurDAO;

    public RegisterServlet() {
        super();
    }

    public void init() {
        assureDAO = new AssureDAOImpl();
        utilisateurDAO = new UtilisateurDAOImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String numeroSecSoc = request.getParameter("numeroSecSoc");
        String adresse = request.getParameter("adresse");
        String dateNaissanceStr = request.getParameter("dateNaissance");

        // Convertissez la chaîne de caractères en objet java.sql.Date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateNaissance = null;
        try {
            java.util.Date parsedDate = dateFormat.parse(dateNaissanceStr);
            dateNaissance = new Date(parsedDate.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            // Gérez l'erreur de parsing de la date ici
        }

        // Vérifiez si l'assuré existe déjà dans la base de données
        Assure existingAssure = assureDAO.getByNumeroSecSoc(numeroSecSoc);
        if (existingAssure == null) {
            // Si l'assuré n'existe pas, créez un nouvel assure avec le numéro de sécurité sociale saisi
            Assure nouvelAssure = new Assure();
            nouvelAssure.setNom(nom);
            nouvelAssure.setPrenom(prenom);
            nouvelAssure.setNumeroSecSoc(numeroSecSoc);
            nouvelAssure.setAdresse(adresse);
            nouvelAssure.setDateNaissance(dateNaissance);

            // Ajoutez l'assuré à la base de données
            assureDAO.ajouterAssure(nouvelAssure);
        }

        // Créez un nouvel utilisateur avec le rôle "client" associé au numéro de sécurité sociale
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Utilisateur nouvelUtilisateur = new Utilisateur(username, password, "client", (existingAssure != null) ? existingAssure.getNumeroSecSoc() : numeroSecSoc);

        // Ajoutez l'utilisateur à la base de données
        utilisateurDAO.addUtilisateur(nouvelUtilisateur);

        // Redirigez vers la page de connexion ou affichez un message de succès
        response.sendRedirect("login.jsp");
    }
}