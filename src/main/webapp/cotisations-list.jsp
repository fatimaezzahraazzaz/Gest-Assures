<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des Cotisations</title>
    <%@ include file="/include/css.jsp" %>
    
</head>
<body>
    <%@ include file="/include/navbar.jsp" %>
    <div id="layoutSidenav">
        <%@ include file="/include/sidebar.jsp" %>
        <div id="layoutSidenav_content">
            <main>
                <div class="container-fluid px-4">
                    <h1 class="mt-4">Liste des Cotisations</h1>
                    <ol class="breadcrumb mb-4">
                        <li class="breadcrumb-item"><a href="index.jsp">Dashboard</a></li>
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
                            <a href="cotisations?action=new" class="btn btn-primary mb-3">Ajouter une nouvelle Cotisation</a>
                            <table id="datatablesSimple" class="display">
                                <thead>
						        <tr>
						            <th>ID</th>
						            <th>NSS</th>
						            <th>Montant</th>
						            <th>Type de cotisation</th>
						            <th>Date de paiement</th>
						            <th>Actions</th>
						        </tr>
                                <tbody>
                                    <c:forEach var="cotisation" items="${listCotisations}">
					            <tr>
					                <td>${cotisation.id}</td>
					                <td>${cotisation.numeroSecSoc}</td>
					                <td>${cotisation.montant}</td>
					                <td>${cotisation.typeCotisation}</td>
					                <td>${cotisation.datePaiement}</td>
                                            <td>
                                                <a href="cotisations?action=edit&id=${cotisation.id}" title="Modifier" class="btn btn-sm btn-warning">
                                                    <i class="fas fa-edit"></i>
                                                </a>
                                                <a href="cotisations?action=delete&id=${cotisation.id}" title="Supprimer" class="btn btn-sm btn-danger">
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
            <%@ include file="/include/footer.jsp" %>
        </div>
    </div>

  
</body>
<%@ include file="/include/js.jsp" %>
</html>



   