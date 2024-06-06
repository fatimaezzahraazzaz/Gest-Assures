<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Mes Demandes de Remboursement</title>
     <%@ include file="/include2/css.jsp" %>
     <%@ include file="/include/css.jsp" %>
    <!-- Inclure SweetAlert2 -->
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</head>
<body>
<%@ include file="/include2/header.jsp" %>
    <%@ include file="/include2/navbar.jsp" %>
 <main>
                <div class="container-fluid px-4">
                    <h3 class="mt-4">Liste des Demandes de remboursement:</h3>
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
                            <a href="demandeRemboursement?action=new" class="btn btn-primary mb-3">Ajouter une nouvelle Demande</a>
                            <table id="datatablesSimple" class="display">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>NSS</th>
                                        <th>Montant</th>
                                        <th>Motif</th>
                                        <th>Statut</th>
                                        <th>Date de la demande</th>
                                        <th>Actions</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="demande" items="${listDemandesRemboursement}">
                                        <tr>
                                            <td>${demande.id}</td>
                                            <td>${demande.nss}</td>
                                            <td>${demande.montant}</td>
                                            <td>${demande.motif}</td>
                                            <td>${demande.statut}</td>
                                            <td>${demande.dateDemande}</td>
                                            <td>
                                                <a href="demandeRemboursement?action=edit&id=${demande.id}" title="Modifier" class="btn btn-sm btn-warning">
                                                    <i class="fas fa-edit"></i>
                                                </a>
                                                <a href="demandeRemboursement?action=delete&id=${demande.id}" title="Supprimer" class="btn btn-sm btn-danger">
                                                    <i class="fas fa-trash-alt"></i>
                                                </a>
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
    <a href="demandeRemboursement?action=new">Ajouter une Demande de Remboursement</a>
</body>
<%@ include file="/include/js.jsp" %>
    <%@ include file="/include2/js.jsp" %>
    <script src="Template2/js/main.js"></script>
</html>
