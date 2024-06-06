<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="navbar navbar-expand-lg bg-white navbar-light sticky-top px-4 px-lg-5">
  <a href="index2.jsp" class="navbar-brand d-flex align-items-center">
    <h1 class="m-0">
      <img class="img-fluid me-3" src="Template2/img/icon/icon-02-primary.png" alt="" />Mon assurance
    </h1>
  </a>
  <button type="button" class="navbar-toggler" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarCollapse">
    <div class="navbar-nav mx-auto bg-light rounded pe-4 py-3 py-lg-0">
      <a href="index2.jsp" class="nav-item nav-link active">Home</a>
      <a href="about.jsp" class="nav-item nav-link">À propos de nous</a>
      <a href="service.jsp" class="nav-item nav-link">Nos Services</a>
      <li>
                <c:choose>
                    <c:when test="${role == 'client'}">
                       <c:url var="mesReclamationsURL" value="/reclamations"></c:url>
					<a href="${mesReclamationsURL}" class="nav-item nav-link">Mes réclamations</a>

                    </c:when>
                   
                </c:choose>
            </li>
            
      <% if(session.getAttribute("username") != null) { %>
        <a href="clientDashboard.jsp" class="nav-item nav-link">Mon espace</a>
      <% } %>
    </div>
  </div>
  <!-- Menu utilisateur -->
  <ul class="navbar-nav">
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
        <i class="fas fa-user-circle" style="font-size: 2em;color: #007bff;"></i>
      </a>
      <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="userDropdown">
        <c:choose>
          <c:when test="${not empty sessionScope.username}">
            <!-- Utilisateur connecté -->
            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/profile">Profil</a></li>
            <li><a class="dropdown-item" href="logout">Se déconnecter</a></li>
          </c:when>
          <c:otherwise>
            <!-- Utilisateur non connecté -->
            <li><a class="dropdown-item" href="login.jsp">Se connecter</a></li>
          </c:otherwise>
        </c:choose>
      </ul>
    </li>
  </ul>
</nav>
