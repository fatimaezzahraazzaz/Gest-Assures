package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Reclamation;
import service.ReclamationService;

@WebServlet("/reclamations")
public class ReclamationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ReclamationService reclamationService;

    public ReclamationServlet() {
        this.reclamationService = new ReclamationService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String role = (String) session.getAttribute("role");
        if (role == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        String action = request.getParameter("action");
        if ("modifier".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Reclamation reclamation = reclamationService.getReclamationById(id);
            request.setAttribute("reclamation", reclamation);
            RequestDispatcher dispatcher = request.getRequestDispatcher("ajouter_modifier_reclamation.jsp");
            dispatcher.forward(request, response);
        } else {
            if (role.equals("admin")) {
                afficherToutesReclamations(request, response);
            } else if (role.equals("client")) {
                String numeroSecSoc = (String) session.getAttribute("numeroSecu");
                if (numeroSecSoc != null) {
                    afficherReclamationsParNumeroSecSoc(request, response, numeroSecSoc);
                } else {
                    response.sendRedirect(request.getContextPath() + "/login");
                }
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("ajouter".equals(action)) {
            ajouterReclamation(request, response);
        } else if ("modifier".equals(action)) {
            modifierReclamation(request, response);
        } else if ("supprimer".equals(action)) {
            supprimerReclamation(request, response);
        }
    }
    

    private void afficherToutesReclamations(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Reclamation> reclamations = reclamationService.getAllReclamations();
        request.setAttribute("reclamations", reclamations);
        RequestDispatcher dispatcher = request.getRequestDispatcher("reclamations.jsp");
        dispatcher.forward(request, response);
    }

    private void afficherReclamationsParNumeroSecSoc(HttpServletRequest request, HttpServletResponse response, String numeroSecSoc)
            throws ServletException, IOException {
        List<Reclamation> reclamations = reclamationService.getReclamationsParNumeroSecSoc(numeroSecSoc);
        request.setAttribute("reclamations", reclamations);
        RequestDispatcher dispatcher = request.getRequestDispatcher("mes_reclamations.jsp");
        dispatcher.forward(request, response);
    }

    private void ajouterReclamation(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Récupérer les paramètres de la requête pour créer une nouvelle réclamation
        String description = request.getParameter("description");
        String dateReclamationStr = request.getParameter("dateReclamation");
        String numeroSecSoc = request.getParameter("numeroSecSoc");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");

        // Conversion de la date
        java.sql.Date dateReclamation = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = sdf.parse(dateReclamationStr);
            dateReclamation = new java.sql.Date(date.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Créer une nouvelle réclamation
        Reclamation reclamation = new Reclamation();
        reclamation.setDescription(description);
        reclamation.setDateReclamation(dateReclamation);
        reclamation.setNumeroSecSoc(numeroSecSoc);
        reclamation.setNom(nom);
        reclamation.setPrenom(prenom);

        // Ajouter la réclamation via le service
        reclamationService.ajouterReclamation(reclamation);

        // Rediriger vers la page des réclamations
        response.sendRedirect(request.getContextPath() + "/reclamations");
    }

    private void modifierReclamation(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String description = request.getParameter("description");
        String dateReclamationStr = request.getParameter("dateReclamation");
        String numeroSecu = request.getParameter("numeroSecSoc");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date dateReclamation = null;
        try {
            dateReclamation = new java.sql.Date(format.parse(dateReclamationStr).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Reclamation reclamation = reclamationService.getReclamationById(id);
        reclamation.setDescription(description);
        reclamation.setDateReclamation(dateReclamation);
        reclamation.setNumeroSecSoc(numeroSecu);
        reclamation.setNom(nom);
        reclamation.setPrenom(prenom);

        reclamationService.modifierReclamation(reclamation);

        response.sendRedirect(request.getContextPath() + "/reclamations");
    }
    protected void supprimerReclamation(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Récupérer l'ID de la réclamation à supprimer
        int id = Integer.parseInt(request.getParameter("reclamationId"));
        
        // Supprimer la réclamation via le service
        reclamationService.supprimerReclamation(id);
        
        // Rediriger vers la page des réclamations
        response.sendRedirect(request.getContextPath() + "/reclamations");
    }

}
