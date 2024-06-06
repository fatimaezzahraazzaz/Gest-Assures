package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Cotisation;
import service.CotisationService;
import dao.AssureDAO;
import dao.impl.AssureDAOImpl;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

@WebServlet("/cotisations")
public class CotisationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CotisationService cotisationService;
    private AssureDAO assureDAO;

    @Override
    public void init() {
        cotisationService = new CotisationService();
        assureDAO = new AssureDAOImpl();
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
                    insertCotisation(request, response);
                    break;
                case "delete":
                    deleteCotisation(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "update":
                    updateCotisation(request, response);
                    break;
                default:
                    listCotisations(request, response);
                    break;
            }
        } else {
            listCotisations(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    private void listCotisations(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String role = (String) session.getAttribute("role");
        List<Cotisation> listCotisations;

        if ("admin".equals(role)) {
            listCotisations = cotisationService.getAllCotisations();
        } else if ("client".equals(role)) {
            String numeroSecSoc = (String) session.getAttribute("numeroSecu");
            System.out.println("Role: " + role);
            System.out.println("Numero Sec Soc (Client): " + numeroSecSoc);

            if (numeroSecSoc != null) {
                listCotisations = cotisationService.getCotisationsByNumeroSecSoc(numeroSecSoc);
                request.setAttribute("listCotisations", listCotisations);
                request.getRequestDispatcher("/cotisations-client.jsp").forward(request, response);
                return;
            } else {
                System.out.println("Client: Numero Sec Soc est null.");
                listCotisations = new ArrayList<>();
            }
        } else {
            listCotisations = new ArrayList<>();
        }

        request.setAttribute("listCotisations", listCotisations);
        request.getRequestDispatcher("/cotisations-list.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/cotisation-form.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Cotisation existingCotisation = cotisationService.getCotisationById(id);
        request.setAttribute("cotisation", existingCotisation);
        request.getRequestDispatcher("/cotisation-form.jsp").forward(request, response);
    }

    private void insertCotisation(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            String numeroSecSoc = request.getParameter("numeroSecSoc");
            double montant = Double.parseDouble(request.getParameter("montant"));
            java.sql.Date datePaiement = java.sql.Date.valueOf(request.getParameter("datePaiement"));
            String typeCotisation = request.getParameter("typeCotisation");

            boolean numeroSecSocExists = cotisationService.numeroSecSocExists(numeroSecSoc);

            if (numeroSecSocExists) {
                Cotisation newCotisation = new Cotisation(numeroSecSoc, montant, datePaiement, typeCotisation);
                cotisationService.addCotisation(newCotisation);

                response.sendRedirect(request.getContextPath() + "/cotisations?action=list");
            } else {
                // Redirection avec message d'erreur
                request.getSession().setAttribute("message", "NSS inexistant.");
                request.getSession().setAttribute("alertType", "error");
                response.sendRedirect(request.getContextPath() + "/cotisations?action=new");
            }
        } catch (NumberFormatException e) {
            throw new ServletException("Invalid input: " + e.getMessage(), e);
        }
    }

    private void updateCotisation(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String numeroSecSoc = request.getParameter("numeroSecSoc");
        double montant = Double.parseDouble(request.getParameter("montant"));
        java.sql.Date datePaiement = java.sql.Date.valueOf(request.getParameter("datePaiement"));
        String typeCotisation = request.getParameter("typeCotisation");

        Cotisation cotisation = new Cotisation(id, numeroSecSoc, montant, datePaiement, typeCotisation);
        cotisationService.updateCotisation(cotisation);
        response.sendRedirect(request.getContextPath() + "/cotisations");
    }

    private void deleteCotisation(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        cotisationService.deleteCotisation(id);
        response.sendRedirect(request.getContextPath() + "/cotisations");
    }
}
