package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Utilisateur;
import service.UtilisateurService;
import dao.DossierMedicalDAO;
import dao.impl.DossierMedicalDAOImpl;
import model.DossierMedical;

import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UtilisateurService utilisateurService = new UtilisateurService();
    private DossierMedicalDAO dossierMedicalDAO = new DossierMedicalDAOImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	  request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Utilisateur utilisateur = utilisateurService.authenticate(username, password);

        if (utilisateur != null) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setAttribute("role", utilisateur.getRole());
            session.setAttribute("assure", utilisateur.getAssure()); // Ajout de l'objet Assure à la session

            // Stockage du numéro de sécurité sociale dans la session
            session.setAttribute("numeroSecu", utilisateur.getNumeroSecSoc());
            // Ajoutez une instruction pour afficher le numéro de sécurité sociale dans la console
            System.out.println("Numéro de sécurité sociale stocké dans la session : " + utilisateur.getNumeroSecSoc());

            session.setMaxInactiveInterval(30 * 60); // 30 minutes

            Cookie usernameCookie = new Cookie("username", username);
            usernameCookie.setMaxAge(30 * 24 * 60 * 60); // 30 jours
            response.addCookie(usernameCookie);

            String role = utilisateur.getRole();
            if ("admin".equals(role)) {
                response.sendRedirect(request.getContextPath() + "/index.jsp");
            } else if ("client".equals(role)) {
                String numeroSecu = (String) session.getAttribute("numeroSecu");

                if (numeroSecu != null) {
                    List<DossierMedical> dossiersMedicaux = dossierMedicalDAO.getByNumeroSecu(numeroSecu);

                    if (dossiersMedicaux != null && !dossiersMedicaux.isEmpty()) {
                        response.sendRedirect(request.getContextPath() + "/clientDashboard.jsp");
                    } else {
                        response.sendRedirect(request.getContextPath() + "/DossierMedicalServlet?action=new");
                    }
                } else {
                    response.sendError(HttpServletResponse.SC_FORBIDDEN);
                }
            }
        }else {
            // Gestion de l'échec de l'authentification
            String errorMessage = "Nom d'utilisateur ou mot de passe incorrect";
            request.setAttribute("error", errorMessage);
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

    }
}
