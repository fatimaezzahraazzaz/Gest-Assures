<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Formulaire Assuré</title>
    <%@ include file="/include/css.jsp" %>
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
                                        <c:when test="${empty assure}">
                                            Ajouter un nouvel assuré
                                        </c:when>
                                        <c:otherwise>
                                            Modifier un assuré
                                        </c:otherwise>
                                    </c:choose>
                                </h3>
                            </div>
                            <div class="card-body">
                                <form action="AssureServlet" method="post">
                                    <c:choose>
                                        <c:when test="${empty assure}">
                                            <input type="hidden" name="action" value="insert">
                                        </c:when>
                                        <c:otherwise>
                                            <input type="hidden" name="action" value="update">
                                            <input type="hidden" name="id" value="${assure.id}">
                                        </c:otherwise>
                                    </c:choose>
                                    <div class="form-floating mb-3">
                                        <input class="form-control" id="inputNumSecu" type="text" placeholder="Numéro de Sécurité Sociale" name="numeroSecSoc" value="${empty assure ? '' : assure.numeroSecSoc}">
                                        <label for="inputNumSecu">Numéro de Sécurité Sociale</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input class="form-control" id="inputNom" type="text" placeholder="Nom" name="nom" value="${empty assure ? '' : assure.nom}">
                                        <label for="inputNom">Nom</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input class="form-control" id="inputPrenom" type="text" placeholder="Prénom" name="prenom" value="${empty assure ? '' : assure.prenom}">
                                        <label for="inputPrenom">Prénom</label>
                                    </div>
                                    
                                    <div class="form-floating mb-3">
                                        <input class="form-control" id="inputAdresse" type="text" placeholder="Adresse" name="adresse" value="${empty assure ? '' : assure.adresse}">
                                        <label for="inputAdresse">Adresse</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input class="form-control" id="inputDateNaissance" type="date" placeholder="Date de Naissance" name="dateNaissance" value="${empty assure ? '' : assure.dateNaissance}">
                                        <label for="inputDateNaissance">Date de Naissance</label>
                                    </div>
                                    <div class="mt-4 mb-0">
                                        <button class="btn btn-primary btn-block" type="submit">
                                            <c:choose>
                                                <c:when test="${empty assure}">
                                                    Ajouter
                                                </c:when>
                                                <c:otherwise>
                                                    Enregistrer les modifications
                                                </c:otherwise>
                                            </c:choose>
                                        </button>
                                    </div>
                                </form>
                            </div>
                            <div class="card-footer text-center py-3">
                                <div class="small"><a href="AssureServlet?action=list">Retour à la liste des assurés</a></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>
    </div>
</div>

<%@ include file="/include/footer.jsp" %>

<script>
    // Fonction pour afficher une alerte SweetAlert2
    function showAlert(message) {
        Swal.fire({
            icon: 'error',
            title: 'Erreur',
            text: message
        });
    }
</script>
<%-- Récupérer le paramètre d'erreur --%>
<% String error = (String) request.getAttribute("error"); %>
<%-- Si le paramètre d'erreur est présent, afficher l'alerte --%>
<% if (error != null && !error.isEmpty()) { %>
    <script>
        showAlert('<%= error %>');
    </script>
<% } %>
<%@ include file="/include/js.jsp" %>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.11.0/dist/sweetalert2.all.min.js"></script>
</body>
</html>
