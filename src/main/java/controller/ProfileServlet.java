package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Assure;
import service.AssureService;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private AssureService assureService;

    public void init() {
        assureService = new AssureService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String role = (String) session.getAttribute("role");
        if (role == null || !role.equals("client")) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        String numeroSecSoc = (String) session.getAttribute("numeroSecu");
        if (numeroSecSoc != null) {
            Assure assure = assureService.getAssureDetails(numeroSecSoc);
            request.setAttribute("assure", assure);
            request.getRequestDispatcher("/Profile.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }
}
