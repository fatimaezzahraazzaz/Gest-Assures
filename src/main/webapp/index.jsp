<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="service.AssureService" %>
<%@ page import="service.CotisationService" %>
<%@ page import="service.DemandeRemboursementService" %>
<%@ page import="service.ReclamationService" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Accueil</title>
 	<%@ include file="/include/css.jsp" %>
</head>
<body>
  <%@ include file="/include/navbar.jsp" %>
   <div id="layoutSidenav">
        <%@ include file="/include/sidebar.jsp" %>
        <div id="layoutSidenav_content">               
<main>
    <div class="container-fluid px-4">
        <h1 class="mt-4">Bienvenue</h1>
        <ol class="breadcrumb mb-4">
            <li class="breadcrumb-item active">Accueil</li>
        </ol>
         <div class="row">
            <div class="col-xl-12 col-md-12">
                <div class="card mb-4 text-center">
                    <div class="card-body">
                        <h2 class="card-title">Bienvenue dans votre application de gestion des assurés</h2>
                        <p class="card-text">
                            Nous sommes ravis de vous accueillir sur notre plateforme de gestion des assurés. Cette application vous permet de gérer facilement et efficacement toutes les informations relatives à vos assurés, cotisations, demandes, dossiers, et plus encore.
                        </p>
                        <p class="card-text">
                            Utilisez les menus de navigation sur la gauche pour accéder aux différentes sections de l'application. Nous espérons que vous trouverez cette plateforme intuitive et utile.
                        </p>
                        <img src="data:image/png;base64,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" class="img-fluid rounded mx-auto d-block my-4" alt="Bienvenue" />
                    </div>
                </div>
            </div>
        </div>
 <%  // Créer une instance de votre service
                                           AssureService assureService = new AssureService();
                       // Appeler une méthode de votre service pour obtenir le nombre total d'assurés
                          int totalAssures = assureService.getTotalAssures();
                                    %>
<div class="row">
    <div class="col-xl-3 col-md-6 mb-4">
        <div class="card border-left-primary shadow h-100 py-2">
            <div class="card-body">
                <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                        <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                            Assurés</div>
                        <div class="h5 mb-0 font-weight-bold text-gray-800"></div>
                            <%= totalAssures %> <!-- Afficher le nombre total d'assurés -->
                        </div>
                    <div class="col-auto">
                        <i class="fas fa-users fa-2x text-gray-300"></i>
                    </div>
                </div>
            </div>
        </div>
    </div>

 <%
 CotisationService cotisationService = new CotisationService();
 double totalCotisation = cotisationService.getTotalCotisation();
%>

<div class="col-xl-3 col-md-6 mb-4">
 <div class="card border-left-success shadow h-100 py-2">
     <div class="card-body">
         <div class="row no-gutters align-items-center">
             <div class="col mr-2">
                 <div class="text-xs font-weight-bold text-success text-uppercase mb-1">
                     Cotisations</div>
                 <div class="h5 mb-0 font-weight-bold text-gray-800">MAD <%= totalCotisation %></div>
             </div>
             <div class="col-auto">
                 <i class="fas fa-dollar-sign fa-2x text-gray-300"></i>
             </div>
         </div>
     </div>
 </div>
</div>

<%  // Créer une instance de votre service
DemandeRemboursementService demanderemboursementService = new DemandeRemboursementService();
                       // Appeler une méthode de votre service pour obtenir le nombre total d'assurés
                          int totaldemande = demanderemboursementService.getTotalCotisation();
                                    %>
 

    <div class="col-xl-3 col-md-6 mb-4">
        <div class="card border-left-info shadow h-100 py-2">
            <div class="card-body">
                <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                        <div class="text-xs font-weight-bold text-info text-uppercase mb-1">
                            Demandes</div>
                        <div class="h5 mb-0 font-weight-bold text-gray-800"></div>
                         <%= totaldemande %>
                    </div>
                    <div class="col-auto">
                        <i class="fas fa-file-alt fa-2x text-gray-300"></i>
                    </div>
                </div>
            </div>
        </div>
    </div>
<%  // Créer une instance de votre service
                                           ReclamationService reclamationService = new ReclamationService();
                       // Appeler une méthode de votre service pour obtenir le nombre total d'assurés
                          int totalReclamation = reclamationService.getTotalReclamation();
                                    %>
    <div class="col-xl-3 col-md-6 mb-4">
        <div class="card border-left-warning shadow h-100 py-2">
            <div class="card-body">
                <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                        <div class="text-xs font-weight-bold text-warning text-uppercase mb-1">
                            Reclamation</div>
                        <div class="h5 mb-0 font-weight-bold text-gray-800"></div>
                        <%= totalReclamation %>
                    </div>
                    <div class="col-auto">
                    <!-- Bouton pour afficher les messages -->
                    <form action="reclamations" method="get">
                        <button type="submit" class="btn btn-primary">Afficher les reclamation</button>
                    </form>
                </div>               
                 </div>
            </div>
        </div>
    </div>
</div>

        <div class="row">
            <div class="col-xl-4 col-md-6 mb-4">
                <div class="card shadow h-100 py-2">
                    <div class="card-body">
                        <div class="row no-gutters align-items-center">
                            <div class="col mr-2">
                                <a href="main?action=assures" class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                    Gérer les Assurés</a>
                            </div>
                            <div class="col-auto">
                                <i class="fas fa-user-cog fa-2x text-gray-300"></i>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-xl-4 col-md-6 mb-4">
                <div class="card shadow h-100 py-2">
                    <div class="card-body">
                        <div class="row no-gutters align-items-center">
                            <div class="col mr-2">
                                <a href="main?action=cotisations" class="text-xs font-weight-bold text-success text-uppercase mb-1">
                                    Gérer les Cotisations</a>
                            </div>
                            <div class="col-auto">
                                <i class="fas fa-wallet fa-2x text-gray-300"></i>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
            
            <div class="col-xl-4 col-md-6 mb-4">
                <div class="card shadow h-100 py-2">
                    <div class="card-body">
                        <div class="row no-gutters align-items-center">
                            <div class="col mr-2">
                                <a href="main?action=demandes" class="text-xs font-weight-bold text-info text-uppercase mb-1">
                                    Gérer les Demandes</a>
                            </div>
                            <div class="col-auto">
                                <i class="fas fa-file-invoice fa-2x text-gray-300"></i>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</main>
<%@ include file="/include/footer.jsp" %>
 </div>


</div>

</body>
<%@ include file="/include/js.jsp" %>
</html>
