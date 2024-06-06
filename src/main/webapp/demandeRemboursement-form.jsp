<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Formulaire de demande de remboursement</title>
    <%@ include file="/include/css.jsp" %>
     <!-- Inclure SweetAlert2 -->
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
                                            <c:when test="${empty demandeRemboursement}">
                                                Nouvelle demande de remboursement
                                            </c:when>
                                            <c:otherwise>
                                                Modifier une demande de remboursement
                                            </c:otherwise>
                                        </c:choose>
                                    </h3>
                                </div>
                                <div class="card-body">
                                    <form action="demandeRemboursement" method="post">
                                        <c:choose>
                                            <c:when test="${empty demandeRemboursement}">
                                                <input type="hidden" name="action" value="insert">
                                            </c:when>
                                            <c:otherwise>
                                                <input type="hidden" name="action" value="update">
                                                <input type="hidden" name="id" value="${demandeRemboursement.id}">
                                            </c:otherwise>
                                        </c:choose>
                                        <div class="form-floating mb-3">
                                           <input class="form-control" id="inputNSS" type="text" placeholder="NSS" name="nss" value="${empty demandeRemboursement ? '' : demandeRemboursement.nss}">
                                            <label for="inputNSS">NSS</label>
                                        </div>
                                        <div class="form-floating mb-3">
                                            <input class="form-control" id="inputMontant" type="text" placeholder="Montant" name="montant" value="${empty demandeRemboursement ? '' : demandeRemboursement.montant}">
                                            <label for="inputMontant">Montant</label>
                                        </div>
                                        <div class="form-floating mb-3">
                                            <input class="form-control" id="inputMotif" type="text" placeholder="Motif" name="motif" value="${empty demandeRemboursement ? '' : demandeRemboursement.motif}">
                                            <label for="inputMotif">Motif</label>
                                        </div>
                                        <div class="form-floating mb-3">
    <c:choose>
        <c:when test="${empty demandeRemboursement || 'client' == role}">
            <input class="form-control" id="inputStatut" type="text" placeholder="Statut" name="statut" value="EN_ATTENTE" readonly>
        </c:when>
        <c:otherwise>
            <select class="form-control" id="inputStatut" name="statut">
                <option value="EN_ATTENTE" ${demandeRemboursement.statut == 'EN_ATTENTE' ? 'selected' : ''}>EN_ATTENTE</option>
                <option value="ACCEPTEE" ${demandeRemboursement.statut == 'ACCEPTEE' ? 'selected' : ''}>ACCEPTEE</option>
                <option value="REFUSEE" ${demandeRemboursement.statut == 'REFUSEE' ? 'selected' : ''}>REFUSEE</option>
            </select>
        </c:otherwise>
    </c:choose>
    <label for="inputStatut">Statut</label>
</div>

                                        <div class="form-floating mb-3">
                                            <input class="form-control" id="inputDateDemande" type="date" placeholder="Date de demande" name="dateDemande" value="${empty demandeRemboursement ? '' : demandeRemboursement.dateDemande}">
                                            <label for="inputDateDemande">Date de demande</label>
                                        </div>
                                        <div class="mt-4 mb-0">
                                            <button class="btn btn-primary btn-block" type="submit">
                                                <c:choose>
                                                    <c:when test="${empty demandeRemboursement}">
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
                                    <div class="small"><a href="demandeRemboursement?action=list">Retour à la liste des demandes de remboursement</a></div>
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
    <c:if test="${not empty nssExists && !nssExists}">
        <script>
            Swal.fire({
                icon: 'error',
                title: 'Erreur',
                text: 'NSS n\'existe pas'
            });
        </script>
    </c:if>



</body>
</html>
