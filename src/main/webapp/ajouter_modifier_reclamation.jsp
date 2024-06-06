<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ajouter/Modifier une réclamation</title>
    <%@ include file="/include/css.jsp" %>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@11.11.0/dist/sweetalert2.min.css">
</head>
<body class="bg-primary">
<div id="layoutAuthentication">
    <div id="layoutAuthentication_content">
        <main>
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-lg-7">
                        <div class="card shadow-lg border-0 rounded-lg mt-5">
                            <div class="card-header">
                                <h3 class="text-center font-weight-light my-4">
                                    <c:choose>
                                        <c:when test="${not empty reclamation}">
                                            Modifier une réclamation
                                        </c:when>
                                        <c:otherwise>
                                            Ajouter une nouvelle réclamation
                                        </c:otherwise>
                                    </c:choose>
                                </h3>
                            </div>
                            <div class="card-body">
                                <form action="reclamations" method="post">
                                    <c:choose>
                                        <c:when test="${not empty reclamation}">
                                            <input type="hidden" name="action" value="modifier">
                                            <input type="hidden" name="id" value="${reclamation.id}">
                                        </c:when>
                                        <c:otherwise>
                                            <input type="hidden" name="action" value="ajouter">
                                        </c:otherwise>
                                    </c:choose>
                                    
                                    <div class="form-floating mb-3">
                                        <input class="form-control" id="numeroSecSoc" type="text" placeholder="Numéro de Sécurité Sociale" name="numeroSecSoc" value="${empty reclamation ? '' : reclamation.numeroSecSoc}" <c:if test="${not empty reclamation}">readonly</c:if>>
                                        <label for="numeroSecSoc">Numéro de Sécurité Sociale</label>
                                    </div>
                                    
                                    <div class="form-floating mb-3">
                                        <input class="form-control" id="nom" type="text" placeholder="Nom" name="nom" value="${empty reclamation ? '' : reclamation.nom}" <c:if test="${not empty reclamation}">readonly</c:if>>
                                        <label for="nom">Nom</label>
                                    </div>
                                    
                                    <div class="form-floating mb-3">
                                        <input class="form-control" id="prenom" type="text" placeholder="Prénom" name="prenom" value="${empty reclamation ? '' : reclamation.prenom}" <c:if test="${not empty reclamation}">readonly</c:if>>
                                        <label for="prenom">Prénom</label>
                                    </div>
                                    
                                    <div class="form-floating mb-3">
                                        <textarea class="form-control" id="description" placeholder="Description" name="description">${empty reclamation ? '' : reclamation.description}</textarea>
                                        <label for="description">Description</label>
                                    </div>
                                    
                                    <div class="form-floating mb-3">
                                        <input class="form-control" id="dateReclamation" type="date" placeholder="Date de réclamation" name="dateReclamation" value="${empty reclamation ? '' : reclamation.dateReclamation}">
                                        <label for="dateReclamation">Date de réclamation</label>
                                    </div>
                                    
                                    <div class="mt-4 mb-0">
                                        <button class="btn btn-primary btn-block" type="submit">
                                            <c:choose>
                                                <c:when test="${not empty reclamation}">
                                                    Enregistrer les modifications
                                                </c:when>
                                                <c:otherwise>
                                                    Ajouter
                                                </c:otherwise>
                                            </c:choose>
                                        </button>
                                    </div>
                                </form>
                            </div>
                            <div class="card-footer text-center py-3">
                                <div class="small"><a href="reclamations?action=list">Retour à la liste des réclamations</a></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>
    </div>
    <%@ include file="/include/footer.jsp" %>
</div>

<%@ include file="/include/js.jsp" %>

</body>
</html>
