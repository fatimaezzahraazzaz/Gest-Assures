package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import dao.AssureDAO;
import dao.impl.AssureDAOImpl;
import model.Assure;
/**
 * Servlet implementation class AssureServlet
 */
@WebServlet("/AssureServlet")

public class AssureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private AssureDAO assureDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssureServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() {
        assureDAO = new AssureDAOImpl();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            if (action != null) {
                switch (action) {
                    case "new":
                        showNewForm(request, response);
                        break;
                    case "insert":
                        insertAssure(request, response);
                        break;
                    case "delete":
                        deleteAssure(request, response);
                        break;
                    case "edit":
                        showEditForm(request, response);
                        break;
                    case "update":
                        updateAssure(request, response);
                        break;
                
                    default:
                        listAssure(request, response);
                        break;
                }
            } else {
                listAssure(request, response);
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("insert".equals(action)) {
            insertAssure(request, response);
        } else if ("update".equals(action)) {
            updateAssure(request, response);
        } else {
            doGet(request, response);
        }
    }

    private void listAssure(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Assure> listAssure = assureDAO.getAllAssures();
        request.setAttribute("listAssure", listAssure);
        request.getRequestDispatcher("assure-list.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("assure-form.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Assure existingAssure = assureDAO.getAssureById(id);
        request.setAttribute("assure", existingAssure);
        request.getRequestDispatcher("assure-form.jsp").forward(request, response);
    }
    private void insertAssure(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String numeroSecSoc = request.getParameter("numeroSecSoc");
        String adresse = request.getParameter("adresse");
        String dateNaissanceStr = request.getParameter("dateNaissance");
        java.sql.Date dateNaissance = null;
        try {
            // Convertir la date de naissance de String en java.sql.Date
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parsedDate = sdf.parse(dateNaissanceStr);
            dateNaissance = new java.sql.Date(parsedDate.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Vérifier si le NSS est unique
        if (assureDAO.isNumeroSecuriteSocialeUnique(numeroSecSoc)) {
            Assure newAssure = new Assure();
            newAssure.setNom(nom);
            newAssure.setPrenom(prenom);
            newAssure.setNumeroSecSoc(numeroSecSoc);
            newAssure.setAdresse(adresse);
            newAssure.setDateNaissance(dateNaissance);
            assureDAO.ajouterAssure(newAssure);
            response.sendRedirect("AssureServlet?action=list");
        } else {
            // Rediriger vers la page avec un message d'erreur
            response.sendRedirect("assure-form.jsp?error=Le NSS existe!!.");
        }
    }

    private void updateAssure(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	HttpSession session = request.getSession();
        String role = (String) session.getAttribute("role");
        String numeroSecSocSession = (String) session.getAttribute("numeroSecu");


        int id = Integer.parseInt(request.getParameter("id"));
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String numeroSecSoc = request.getParameter("numeroSecSoc");
        String adresse = request.getParameter("adresse");
        String dateNaissanceStr = request.getParameter("dateNaissance");
        java.sql.Date dateNaissance = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parsedDate = sdf.parse(dateNaissanceStr);
            dateNaissance = new java.sql.Date(parsedDate.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (role != null && role.equals("admin")) {
            if (assureDAO.isNumeroSecSocUniqueForUpdate(id, numeroSecSoc)) {
                Assure assure = new Assure();
                assure.setId(id);
                assure.setNom(nom);
                assure.setPrenom(prenom);
                assure.setNumeroSecSoc(numeroSecSoc);
                assure.setAdresse(adresse);
                assure.setDateNaissance(dateNaissance);

                assureDAO.modifierAssure(assure);
                System.out.println("Assuré mis à jour : ID=" + id);
                response.sendRedirect("AssureServlet?action=list");
            } else {
                response.sendRedirect("AssureServlet?action=edit&id=" + id + "&error=Le NSS existe!!");
            }
        } else if (role != null && role.equals("client")) {
            // Mise à jour par le client
            System.out.println("Client is updating profile. Session numeroSecSoc: " + numeroSecSocSession);

            Assure clientAssure = assureDAO.getByNumeroSecSoc(numeroSecSocSession);
            if (clientAssure != null) {
                System.out.println("Assuré trouvé pour le client: " + clientAssure);

                // Vérifier si l'ID de l'assuré correspond à l'ID de l'utilisateur connecté
                if (clientAssure.getId() == id) {
                    clientAssure.setNom(nom);
                    clientAssure.setPrenom(prenom);
                    clientAssure.setNumeroSecSoc(numeroSecSoc);
                    clientAssure.setAdresse(adresse);
                    clientAssure.setDateNaissance(dateNaissance);

                    assureDAO.modifierAssure(clientAssure);
                    System.out.println("Profil d'assuré du client mis à jour : ID=" + id);

                    response.sendRedirect("profile.jsp");
                } else {
                    // Journaliser et rediriger en cas de non-correspondance d'ID
                    System.out.println("Erreur : L'ID de l'assuré ne correspond pas à celui de l'utilisateur connecté.");
                    response.sendRedirect("error.jsp");
                }
            } else {
                // Journaliser et rediriger en cas de non-trouvaille d'assuré
                System.out.println("Erreur : Aucun assuré trouvé avec le numéro de sécurité sociale : " + numeroSecSocSession);
                response.sendRedirect("error.jsp");
            }
        } else {
            response.sendRedirect("login.jsp");
        }
    }



    private void deleteAssure(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Récupérer l'ID de l'assuré à supprimer depuis la requête
        int id = Integer.parseInt(request.getParameter("id"));
        
        try {
            // Appeler la méthode supprimerAssure du DAO avec l'ID récupéré
            assureDAO.supprimerAssure(id);
            System.out.println("Assuré supprimé : ID=" + id);
            
            // Rediriger vers la page de liste des assurés après la suppression
            response.sendRedirect("AssureServlet?action=list");
        } catch (Exception e) {
            e.printStackTrace();
            // Gérer les erreurs de suppression
            // Vous pouvez rediriger vers une page d'erreur ou afficher un message à l'utilisateur
            response.sendRedirect("AssureServlet?action=list&error=Erreur lors de la suppression de l'assuré.");
        }
    }


}