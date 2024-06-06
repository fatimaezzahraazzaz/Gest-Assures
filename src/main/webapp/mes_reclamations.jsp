<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Mes reclamation</title>
    <%@ include file="/include2/css.jsp" %>
    <%@ include file="/include/css.jsp" %>
</head>
<body>
    <%@ include file="/include2/header.jsp" %>
    <%@ include file="/include2/navbar.jsp" %>
    <div id="layoutSidenav_content">
        <main>
            <div class="container-fluid px-4">
                <h3 class="mt-4">Mes reclamation:</h3>
                <ol class="breadcrumb mb-4">
                    <li class="breadcrumb-item"><a href="clientDashboard.jsp">Mon espace</a></li>
                    <li class="breadcrumb-item active">Tables</li>
                </ol>
                
                <div class="card mb-4">
                    <div class="card-header">
                        <svg class="svg-inline--fa fa-table me-1" aria-hidden="true" focusable="false" data-prefix="fas" data-icon="table" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512" data-fa-i2svg="">
                            <path fill="currentColor" d="M64 256V160H224v96H64zm0 64H224v96H64V320zm224 96V320H448v96H288zM448 256H288V160H448v96zM64 32C28.7 32 0 60.7 0 96V416c0 35.3 28.7 64 64 64H448c35.3 0 64-28.7 64-64V96c0-35.3-28.7-64-64-64H64z"></path>
                        </svg>
                        DataTable Example
                    </div>
                    <div class="card-body">
                        <a href="ajouter_modifier_reclamation.jsp" class="btn btn-primary mb-3">Ajouter une nouvelle Cotisation</a>
                        <table id="datatablesSimple" class="display">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Numéro de Sécurité Sociale</th>
                                    <th>Nom</th>
                                    <th>Prénom</th>
                                    <th>Description</th>
                                    <th>Date</th>
                                    <th>Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="reclamation" items="${reclamations}">
                                    <tr>
                                        <td>${reclamation.id}</td>
                                        <td>${reclamation.numeroSecSoc}</td>
                                        <td>${reclamation.nom}</td>
                                        <td>${reclamation.prenom}</td>
                                        <td>${reclamation.description}</td>
                                        <td>${reclamation.dateReclamation}</td>
                                        <td>
                                            <a href="reclamations?action=modifier&id=${reclamation.id}" title="Modifier" class="btn btn-sm btn-warning">
                                                <i class="fas fa-edit"></i>
                                            </a>
                                            <form action="reclamations" method="post" onsubmit="return confirm('Êtes-vous sûr de vouloir supprimer cette cotisation?');" style="display:inline;">
                                                <input type="hidden" name="action" value="supprimer">
                                                <input type="hidden" name="reclamationId" value="${reclamation.id}">
                                                <button type="submit" title="Supprimer" class="btn btn-sm btn-danger">
                                                    <i class="fas fa-trash-alt"></i>
                                                </button>
                                            </form>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </main>
        <%@ include file="/include2/Footer.jsp" %>
    </div>
    <%@ include file="/include/js.jsp" %>
    <%@ include file="/include2/js.jsp" %>
    <script src="Template2/js/main.js"></script>
</body>
</html>
