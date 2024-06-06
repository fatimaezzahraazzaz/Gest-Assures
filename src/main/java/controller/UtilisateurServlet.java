package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Utilisateur;
import service.UtilisateurService;

import java.io.IOException;
import java.util.List;

@WebServlet("/utilisateurs")
public class UtilisateurServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UtilisateurService utilisateurService;

    public void init() {
        utilisateurService = new UtilisateurService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "new":
                    showNewForm(request, response);
                    break;
                case "insert":
                    insertUtilisateur(request, response);
                    break;
                case "delete":
                    deleteUtilisateur(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "update":
                    updateUtilisateur(request, response);
                    break;
                default:
                    listUtilisateurs(request, response);
                    break;
            }
        } else {
            listUtilisateurs(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    private void listUtilisateurs(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Utilisateur> listUtilisateurs = utilisateurService.getAllUtilisateurs();
        request.setAttribute("listUtilisateurs", listUtilisateurs);
        request.getRequestDispatcher("/utilisateurs-list.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/utilisateur-form.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String numeroSecSoc = request.getParameter("numeroSecSoc");
        Utilisateur existingUtilisateur = utilisateurService.getUtilisateurByNumeroSecSoc(numeroSecSoc);
        request.setAttribute("utilisateur", existingUtilisateur);
        request.getRequestDispatcher("/utilisateur-form.jsp").forward(request, response);
    }

    private void insertUtilisateur(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        String numeroSecSoc = request.getParameter("numeroSecSoc");

        Utilisateur newUtilisateur = new Utilisateur( username, password, role,numeroSecSoc);
        utilisateurService.addUtilisateur(newUtilisateur);
        response.sendRedirect(request.getContextPath() + "/utilisateurs");
    }


    private void updateUtilisateur(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        String numeroSecSoc = request.getParameter("numeroSecSoc");
        Utilisateur utilisateur = new Utilisateur( username, password, role,numeroSecSoc);
        utilisateurService.updateUtilisateur(utilisateur);
        response.sendRedirect(request.getContextPath() + "/utilisateurs");
    }


    private void deleteUtilisateur(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        utilisateurService.deleteUtilisateur(id);
        response.sendRedirect(request.getContextPath() + "/utilisateurs");
    }
}
