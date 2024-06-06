<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profil</title>
    <%@ include file="/include2/css.jsp" %>
    <!-- Inclure Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- Inclure les animations CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css">
    <!-- Style personnalisé pour les champs en lecture seule -->
    <style>
        .form-control[readonly] {
            background-color: #fff;
            opacity: 1;
        }
    </style>
</head>
<body>
    <%@ include file="/include2/header.jsp" %>
    <%@ include file="/include2/navbar.jsp" %>
    
    <div class="container-xxl py-5">
        <div class="container d-flex justify-content-center">
            <div class="col-lg-8 wow fadeIn" data-wow-delay="0.1s">
                <h1 class="display-6 mb-5 text-center">Profil</h1>
                <c:if test="${not empty assure}">
                    <form>
                        <div class="row g-3">
                            <div class="col-12">
                                <div class="form-floating">
                                    <input type="text" class="form-control" id="numeroSecSoc" placeholder="NSS" value="${assure.numeroSecSoc}" readonly/>
                                    <label for="numeroSecSoc">NSS</label>
                                </div>
                            </div>
                            <div class="col-12">
                                <div class="form-floating">
                                    <input type="text" class="form-control" id="nom" placeholder="Nom" value="${assure.nom}" readonly/>
                                    <label for="nom">Nom</label>
                                </div>
                            </div>
                            <div class="col-12">
                                <div class="form-floating">
                                    <input type="text" class="form-control" id="prenom" placeholder="Prénom" value="${assure.prenom}" readonly/>
                                    <label for="prenom">Prénom</label>
                                </div>
                            </div>
                            <div class="col-12">
                                <div class="form-floating">
                                    <input type="text" class="form-control" id="adresse" placeholder="Adresse" value="${assure.adresse}" readonly/>
                                    <label for="adresse">Adresse</label>
                                </div>
                            </div>
                            <div class="col-12">
                                <div class="form-floating">
                                    <input type="text" class="form-control" id="dateNaissance" placeholder="Date de Naissance" value="${assure.dateNaissance}" readonly/>
                                    <label for="dateNaissance">Date de Naissance</label>
                                </div>
                            </div>
                        </div>
                    </form>
                </c:if>
            </div>
        </div>
    </div>
	 <%@ include file="/include2/Footer.jsp" %>
    <%@ include file="/include/js.jsp" %>
    <%@ include file="/include2/js.jsp" %>
    <!-- Inclure les scripts Bootstrap et les autres scripts nécessaires -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="Template2/js/main.js"></script>
</body>
</html>
