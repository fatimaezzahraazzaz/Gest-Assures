package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "assures":
                    request.getRequestDispatcher("/AssureServlet").forward(request, response);
                    break;
                case "cotisations":
                    request.getRequestDispatcher("/cotisations").forward(request, response);
                    break;
                case "demandes":
                    request.getRequestDispatcher("/demandeRemboursement").forward(request, response);
                    break;
                case "dossiers":
                    request.getRequestDispatcher("/DossierMedicalServlet").forward(request, response);
                    break;
                case "utilisateurs":
                    request.getRequestDispatcher("/utilisateurs").forward(request, response);
                    break;
                case "reclamations":
                    request.getRequestDispatcher("/reclamations").forward(request, response);
                    break;
                default:
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                    break;
            }
        } else {
            request.getRequestDispatcher("/index2.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
