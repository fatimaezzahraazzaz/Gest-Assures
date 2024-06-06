<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Client Dashboard</title>
    <%@ include file="/include2/css.jsp" %>
</head>
<body>
    <%@ include file="/include2/header.jsp" %>
    <%@ include file="/include2/navbar.jsp" %>
    
    
    
<div class="container py-5">
    <h1 class="text-center mb-4">Bienvenue, ${sessionScope.username}!</h1>
    <div class="row g-4 justify-content-center">
        <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.1s">
            <div class="service-item rounded h-100 p-5">
                <div class="d-flex align-items-center ms-n5 mb-4">
                    <div class="service-icon flex-shrink-0 bg-primary rounded-end me-4">
                        <img class="img-fluid" src="Template2/img/icon/icon-07-light.png" alt="Icone Cotisations">
                    </div>
                    <div>
                        <h4 class="card-title mb-3">Cotisations</h4>
                        <p class="card-text">Consultez vos cotisations et bénéficiaires.</p>
                        <a href="cotisations?action=listCotisations" class="btn btn-primary text-white">Voir mes cotisations</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.3s">
            <div class="service-item rounded h-100 p-5">
                <div class="d-flex align-items-center ms-n5 mb-4">
                    <div class="service-icon flex-shrink-0 bg-primary rounded-end me-4">
                        <img class="img-fluid" src="Template2/img/icon/icon-01-light.png" alt="Icone Demandes de remboursement">
                    </div>
                    <div>
                        <h4 class="card-title mb-3">Demandes de remboursement</h4>
                        <p class="card-text">Consultez vos demandes de remboursement.</p>
                        <a href="demandeRemboursement?action=listDemandesRemboursement" class="btn btn-primary text-white">Voir mes demandes</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.3s">
            <div class="service-item rounded h-100 p-5">
                <div class="d-flex align-items-center ms-n5 mb-4">
                    <div class="service-icon flex-shrink-0 bg-primary rounded-end me-4">
                        <img class="img-fluid" src="Template2/img/icon/icon-05-light.png" alt="Icone Dossier médical">
                    </div>
                    <div>
                        <h4 class="card-title mb-3">Dossier médical</h4>
                        <p class="card-text">Consultez votre dossier médical.</p>
                        <a href="DossierMedicalServlet?action=checkDossier" class="btn btn-primary text-white">Voir mon dossier médical</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


    <%@ include file="/include2/Footer.jsp" %>
    
    
</body>
<%@ include file="/include2/js.jsp" %>
<script src="Template2/js/main.js"></script>
 
</html>
