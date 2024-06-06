package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.DossierMedical;
import dao.DossierMedicalDAO;
import dao.UtilisateurDAO;
import dao.impl.DossierMedicalDAOImpl;
import dao.impl.UtilisateurDAOImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/DossierMedicalServlet")
public class DossierMedicalServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DossierMedicalDAO dossierMedicalDAO;

    @Override
    public void init() {
        dossierMedicalDAO = new DossierMedicalDAOImpl();
       
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        String role = (String) session.getAttribute("role");
        String action = request.getParameter("action");
        
        if (action == null) {
            action = "list";
        }

        try {
            switch (action) {
                case "new":
                    if ("admin".equals(role) || "client".equals(role)) {
                        showNewForm(request, response);
                    } else {
                        response.sendError(HttpServletResponse.SC_FORBIDDEN);
                    }
                    break;
                case "insert":
                    if ("admin".equals(role) || "client".equals(role)) {
                        insertDossierMedical(request, response);
                    } else {
                        response.sendError(HttpServletResponse.SC_FORBIDDEN);
                    }
                    break;
                case "delete":
                    if ("admin".equals(role) || "client".equals(role)) {
                        deleteDossierMedical(request, response);
                    } else {
                        response.sendError(HttpServletResponse.SC_FORBIDDEN);
                    }
                    break;
                case "edit":
                	 String numeroSecu = request.getParameter("numeroSecu");
                    if ("admin".equals(role) || "client".equals(role)) {
                        showEditForm(request, response);
                    } else {
                        response.sendError(HttpServletResponse.SC_FORBIDDEN);
                    }
                    break;
                case "update":
                    if ("admin".equals(role) || "client".equals(role)) {
                        updateDossierMedical(request, response);
                    } else {
                        response.sendError(HttpServletResponse.SC_FORBIDDEN);
                    }
                    break;
                case "checkDossier":
                    if ("client".equals(role)) {
                        checkClientDossierMedical(request, response);
                    } else {
                        response.sendError(HttpServletResponse.SC_FORBIDDEN);
                    }
                    break;
                default:
                    if ("admin".equals(role)) {
                        listDossiersMedicaux(request, response);
                    } else if ("client".equals(role)) {
                        viewClientDossierMedical(request, response);
                    } else {
                        response.sendError(HttpServletResponse.SC_FORBIDDEN);
                    }
                    break;
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private void listDossiersMedicaux(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<DossierMedical> listDossiersMedicaux = dossierMedicalDAO.getAllDossiersMedicaux();
        request.setAttribute("listDossiersMedicaux", listDossiersMedicaux);
        request.getRequestDispatcher("/dossierMedical-list.jsp").forward(request, response);
    }

    private void viewClientDossierMedical(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        HttpSession session = request.getSession();
        String numeroSecu = (String) session.getAttribute("numeroSecu");

        if (numeroSecu != null) {
            List<DossierMedical> dossiersMedicaux = dossierMedicalDAO.getByNumeroSecu(numeroSecu);

            System.out.println("Numéro de sécurité sociale récupéré de la session : " + numeroSecu);
            System.out.println("Nombre de dossiers médicaux trouvés : " + dossiersMedicaux.size());

            if (dossiersMedicaux != null && !dossiersMedicaux.isEmpty()) {
                // Afficher le formulaire d'édition si un dossier médical est trouvé
                DossierMedical dossierMedical = dossiersMedicaux.get(0);
                request.setAttribute("dossierMedical", dossierMedical);
                request.getRequestDispatcher("/dossierMedical-form.jsp").forward(request, response);
            } else {
                // Sinon, afficher le formulaire de création d'un nouveau dossier médical
                request.getRequestDispatcher("/dossierMedical-form.jsp").forward(request, response);
            }
        } else {
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
        }
    }


    private void checkClientDossierMedical(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        HttpSession session = request.getSession();
        String numeroSecu = (String) session.getAttribute("numeroSecu");

        if (numeroSecu != null) {
            List<DossierMedical> dossiersMedicaux = dossierMedicalDAO.getByNumeroSecu(numeroSecu);

            if (dossiersMedicaux != null && !dossiersMedicaux.isEmpty()) {
                // Si un dossier médical est trouvé, afficher le formulaire d'édition
                DossierMedical dossierMedical = dossiersMedicaux.get(0);
                request.setAttribute("dossierMedical", dossierMedical);
                request.getRequestDispatcher("/dossierMedical-form.jsp").forward(request, response);
            } else {
                // Si aucun dossier médical n'est trouvé, rediriger vers la création d'un nouveau dossier médical
                response.sendRedirect("DossierMedicalServlet?action=new");
            }
        } else {
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
        }
    }




    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/dossierMedical-form.jsp").forward(request, response);
    }

    private void insertDossierMedical(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
        try {
            String numeroSecu = request.getParameter("numeroSecu");
            String GroupeSanguin = request.getParameter("GroupeSanguin");
            String Allergies = request.getParameter("Allergies");
            String AntecedentsMedicaux = request.getParameter("AntecedentsMedicaux");
            String ListeMedicamentsPrescrits = request.getParameter("ListeMedicamentsPrescrits");

            UtilisateurDAO utilisateurDAO = new UtilisateurDAOImpl();
            boolean numeroSecuExists = utilisateurDAO.isNumeroSecuExists(numeroSecu);



            if (numeroSecuExists) {
                DossierMedical newDossierMedical = new DossierMedical(numeroSecu, GroupeSanguin, Allergies, AntecedentsMedicaux, ListeMedicamentsPrescrits);
                dossierMedicalDAO.insertDossierMedical(newDossierMedical);
                
                HttpSession session = request.getSession();
                String role = (String) session.getAttribute("role");

                if ("client".equals(role)) {
                    response.sendRedirect(request.getContextPath() + "/clientDashboard.jsp");
                } else {
                    response.sendRedirect("DossierMedicalServlet?action=list"); // Redirection vers la liste des dossiers médicaux pour l'admin
                }
            } else {
                // Transmettez la valeur de numeroSecuExists à la JSP
                request.setAttribute("numeroSecuExists", numeroSecuExists);
                showNewForm(request, response);
            }
        } catch (NumberFormatException e) {
            throw new ServletException("Invalid input: " + e.getMessage(), e);
        }
    }


    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        HttpSession session = request.getSession();
        String role = (String) session.getAttribute("role");
        String numeroSecu = (String) session.getAttribute("numeroSecu");

        String idParam = request.getParameter("id");
        if (idParam != null) {
            try {
                int id = Integer.parseInt(idParam);
                DossierMedical existingDossierMedical = dossierMedicalDAO.getById(id);

                if (("admin".equals(role) || ("client".equals(role) && existingDossierMedical != null && existingDossierMedical.getNumeroSecu().equals(numeroSecu)))) {
                    request.setAttribute("dossierMedical", existingDossierMedical);
                    request.getRequestDispatcher("/dossierMedical-form.jsp").forward(request, response);
                } else {
                    response.sendError(HttpServletResponse.SC_FORBIDDEN);
                }
            } catch (NumberFormatException e) {
                throw new ServletException("Invalid input: " + e.getMessage(), e);
            }
        } else if (numeroSecu != null) {
            // Si aucun identifiant de dossier n'est fourni, mais un numéro de sécurité sociale est disponible dans la session
            // Rediriger vers le formulaire d'édition du dossier médical du client en utilisant son numéro de sécurité sociale
            response.sendRedirect("DossierMedicalServlet?action=edit&numeroSecu=" + numeroSecu);
        } else {
            // Gérer le cas où aucun identifiant de dossier ni de numéro de sécurité sociale n'est fourni
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "L'identifiant du dossier médical est requis.");
        }
    }





    private void updateDossierMedical(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
        try {
            HttpSession session = request.getSession();
            String role = (String) session.getAttribute("role");
            String numeroSecu = (String) session.getAttribute("numeroSecu");
            int id = Integer.parseInt(request.getParameter("id"));

            DossierMedical existingDossierMedical = dossierMedicalDAO.getById(id);

            if ("client".equals(role) && (existingDossierMedical == null || !existingDossierMedical.getNumeroSecu().equals(numeroSecu))) {
                response.sendError(HttpServletResponse.SC_FORBIDDEN);
                return;
            }

            String GroupeSanguin = request.getParameter("GroupeSanguin");
            String Allergies = request.getParameter("Allergies");
            String AntecedentsMedicaux = request.getParameter("AntecedentsMedicaux");
            String ListeMedicamentsPrescrits = request.getParameter("ListeMedicamentsPrescrits");

            DossierMedical dossierMedical = new DossierMedical(id, numeroSecu, GroupeSanguin, Allergies, AntecedentsMedicaux, ListeMedicamentsPrescrits);

            System.out.println("Updating dossier with ID: " + id); // Debug
            dossierMedicalDAO.updateDossierMedical(dossierMedical);

            if ("client".equals(role)) {
                response.sendRedirect(request.getContextPath() + "/clientDashboard.jsp");
            } else {
                response.sendRedirect("DossierMedicalServlet?action=list"); // Redirection pour l'admin
            }
        } catch (NumberFormatException e) {
            throw new ServletException("Invalid input: " + e.getMessage(), e);
        }
    }


    private void deleteDossierMedical(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        dossierMedicalDAO.deleteDossierMedical(id);

        HttpSession session = request.getSession();
        String role = (String) session.getAttribute("role");

        if ("client".equals(role)) {
            response.sendRedirect(request.getContextPath() + "/clientDashboard.jsp");
        } else {
            response.sendRedirect("DossierMedicalServlet?action=list"); // Redirection pour l'admin
        }
    }

}
