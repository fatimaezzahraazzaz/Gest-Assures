<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Formulaire Dossier Médical</title>
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
                                            <c:when test="${dossierMedical != null}">
                                                Modifier Dossier Médical
                                            </c:when>
                                            <c:otherwise>
                                                Ajouter Dossier Médical
                                            </c:otherwise>
                                        </c:choose>
                                    </h3>
                                </div>
                                <div class="card-body">
                                    <form id="dossierMedicalForm" action="DossierMedicalServlet" method="post">
                                        <c:if test="${dossierMedical != null}">
                                            <input type="hidden" name="action" value="update">
                                            <input type="hidden" name="id" value="${dossierMedical.id}">
                                        </c:if>
                                        <c:if test="${dossierMedical == null}">
                                            <input type="hidden" name="action" value="insert">
                                        </c:if>
                                        <div class="form-floating mb-3">
                                            <input class="form-control" id="inputNumeroSecu" type="text" placeholder="Numéro Sécurité Sociale" name="numeroSecu" value="${dossierMedical.numeroSecu}">
                                            <label for="inputNumeroSecu">Numéro Sécurité Sociale</label>
                                        </div>
                                        <div class="form-floating mb-3">
                                            <input class="form-control" id="inputGroupeSanguin" type="text" placeholder="Groupe Sanguin" name="GroupeSanguin" value="${dossierMedical.groupeSanguin}">
                                            <label for="inputGroupeSanguin">Groupe Sanguin</label>
                                        </div>
                                        <div class="form-floating mb-3">
                                            <input class="form-control" id="inputAllergies" type="text" placeholder="Allergies" name="Allergies" value="${dossierMedical.allergies}">
                                            <label for="inputAllergies">Allergies</label>
                                        </div>
                                        <div class="form-floating mb-3">
                                            <input class="form-control" id="inputAntecedentsMedicaux" type="text" placeholder="Antécédents Médicaux" name="AntecedentsMedicaux" value="${dossierMedical.antecedentsMedicaux}">
                                            <label for="inputAntecedentsMedicaux">Antécédents Médicaux</label>
                                        </div>
                                        <div class="form-floating mb-3">
                                            <input class="form-control" id="inputListeMedicamentsPrescrits" type="text" placeholder="Liste des Médicaments Prescrits" name="ListeMedicamentsPrescrits" value="${dossierMedical.listeMedicamentsPrescrits}">
                                            <label for="inputListeMedicamentsPrescrits">Liste des Médicaments Prescrits</label>
                                        </div>

                                        <div class="mt-4 mb-0 d-grid gap-2 d-md-flex justify-content-md-end">
										    <button class="btn btn-primary me-md-2" type="submit">Enregistrer</button>
										    <c:if test="${dossierMedical != null}">
										        <button class="btn btn-danger" type="submit" name="action" value="delete" formaction="DossierMedicalServlet?action=delete&id=${dossierMedical.id}" onclick="return confirm('Êtes-vous sûr de vouloir supprimer ce dossier médical ?')">Supprimer</button>
										    </c:if>
										</div>

                                    </form>
                                    
								 </div>
                               <div class="card-footer text-center py-3">
								    <div class="small">
								        <c:choose>
								            <c:when test="${'client'.equals(role)}">
								                <a href="clientDashboard.jsp">Retour au tableau de bord du client</a>
								            </c:when>
								            <c:when test="${'admin'.equals(role)}">
								                <a href="DossierMedicalServlet?action=list">Retour à la liste des Dossier</a>
								            </c:when>
								            <c:otherwise>
								                <!-- Redirection vers une page par défaut si le rôle n'est ni client ni admin -->
								                <a href="defaultPage.jsp">Retour</a>
								            </c:otherwise>
								        </c:choose>
								    </div>
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
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<!-- SweetAlert2 Alert -->
<c:if test="${not empty numeroSecuExists && !numeroSecuExists}">
    <script>
        Swal.fire({
            icon: 'error',
            title: 'Erreur',
            text: 'Numéro de sécurité sociale n\'existe pas'
        });
    </script>
</c:if>
    
</body>
</html>
