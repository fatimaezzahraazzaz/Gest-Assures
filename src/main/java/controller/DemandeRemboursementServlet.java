package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.DemandeRemboursement;
import model.Statut;
import service.DemandeRemboursementService;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/demandeRemboursement")
public class DemandeRemboursementServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DemandeRemboursementService demandeRemboursementService;

    public DemandeRemboursementServlet() {
        super();
    }

    public void init() {
        demandeRemboursementService = new DemandeRemboursementService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            if (action != null) {
                switch (action) {
                    case "new":
                        showNewForm(request, response);
                        break;
                    case "insert":
                        insertDemandeRemboursement(request, response);
                        break;
                    case "delete":
                        deleteDemandeRemboursement(request, response);
                        break;
                    case "edit":
                        showEditForm(request, response);
                        break;
                    case "update":
                        updateDemandeRemboursement(request, response);
                        break;
                    default:
                        listDemandesRemboursement(request, response);
                        break;
                }
            } else {
                response.sendRedirect("demandeRemboursement?action=list");
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    private void listDemandesRemboursement(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String role = (String) session.getAttribute("role");
        List<DemandeRemboursement> listDemandesRemboursement;

        if ("admin".equals(role)) {
            listDemandesRemboursement = demandeRemboursementService.getAllDemandeRemboursement();
        } else if ("client".equals(role)) {
            String nss = (String) session.getAttribute("numeroSecu");
            listDemandesRemboursement = demandeRemboursementService.getDemandesRemboursementByNSS(nss);
            request.setAttribute("listDemandesRemboursement", listDemandesRemboursement);
            request.getRequestDispatcher("/remboursement-client.jsp").forward(request, response);
            return;
        } else {
            listDemandesRemboursement = new ArrayList<>();
        }

        request.setAttribute("listDemandesRemboursement", listDemandesRemboursement);
        request.getRequestDispatcher("/demandeRemboursement-list.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Récupérez toutes les valeurs possibles de votre enum Statut
        Statut[] statuts = Statut.values();
        // Transmettez le tableau des statuts à la JSP
        request.setAttribute("statuts", statuts);

        request.getRequestDispatcher("/demandeRemboursement-form.jsp").forward(request, response);
    }




    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        DemandeRemboursement existingDemandeRemboursement = demandeRemboursementService.getDemandeRemboursementById(id);
        Statut[] statuts = Statut.values();
        request.setAttribute("statuts", statuts);
        request.setAttribute("demandeRemboursement", existingDemandeRemboursement);
        request.getRequestDispatcher("/demandeRemboursement-form.jsp").forward(request, response);
    }

    private void insertDemandeRemboursement(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String nss = request.getParameter("nss");
        double montant = Double.parseDouble(request.getParameter("montant"));
        String motif = request.getParameter("motif");
        Statut statut = Statut.valueOf(request.getParameter("statut"));
        Date dateDemande = Date.valueOf(request.getParameter("dateDemande"));

        // Vérifiez si le NSS existe avant d'ajouter la demande de remboursement
        boolean nssExists = demandeRemboursementService.isNssExists(nss);

        if (nssExists) {
            DemandeRemboursement newDemandeRemboursement = new DemandeRemboursement(nss, montant, motif, statut, dateDemande);
            demandeRemboursementService.addDemandeRemboursement(newDemandeRemboursement);
            response.sendRedirect("demandeRemboursement?action=list");
        } else {
            // Transmettez la valeur de nssExists à la JSP
            request.setAttribute("nssExists", nssExists);
            showNewForm(request, response);
        }
    }


    private void updateDemandeRemboursement(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nss = request.getParameter("nss");
        double montant = Double.parseDouble(request.getParameter("montant"));
        String motif = request.getParameter("motif");
        Statut statut = Statut.valueOf(request.getParameter("statut"));
        Date dateDemande = Date.valueOf(request.getParameter("dateDemande"));

        if (demandeRemboursementService.isNssExists(nss)) {
            DemandeRemboursement demandeRemboursement = new DemandeRemboursement(id, nss, montant, motif, statut, dateDemande);
            demandeRemboursementService.updateDemandeRemboursement(demandeRemboursement);
            response.sendRedirect("demandeRemboursement?action=list");
        } else {
            request.setAttribute("alert", "NSS n'existe pas");
            showEditForm(request, response);
        }
    }

    private void deleteDemandeRemboursement(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        demandeRemboursementService.deleteDemandeRemboursement(id);
        response.sendRedirect("demandeRemboursement?action=list");
    }
}
