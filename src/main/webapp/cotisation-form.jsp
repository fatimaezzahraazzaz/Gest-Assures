<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Formulaire Cotisation</title>
    <%@ include file="/include/css.jsp" %>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@11.11.0/dist/sweetalert2.min.css">
</head>
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
                                        <c:when test="${empty cotisation}">
                                            Ajouter une nouvelle cotisation
                                        </c:when>
                                        <c:otherwise>
                                            Modifier une cotisation
                                        </c:otherwise>
                                    </c:choose>
                                </h3>
                            </div>
                            <div class="card-body">
                                <form action="cotisations" method="post">
                                    <c:choose>
                                        <c:when test="${empty cotisation}">
                                            <input type="hidden" name="action" value="insert">
                                        </c:when>
                                        <c:otherwise>
                                            <input type="hidden" name="action" value="update">
                                            <input type="hidden" name="id" value="${cotisation.id}">
                                        </c:otherwise>
                                    </c:choose>
                                    <div class="form-floating mb-3">
                                        <input class="form-control" id="inputNumeroSecSoc" type="text" placeholder="Numéro de sécurité sociale" name="numeroSecSoc" value="${empty cotisation ? '' : cotisation.numeroSecSoc}">
                                        <label for="inputNumeroSecSoc">Numéro de sécurité sociale</label>
                                    </div>

                                    <div class="form-floating mb-3">
                                        <input class="form-control" id="inputMontant" type="text" placeholder="Montant" name="montant" value="${empty cotisation ? '' : cotisation.montant}">
                                        <label for="inputMontant">Montant</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input class="form-control" id="inputTypeCotisation" type="text" placeholder="Type de cotisation" name="typeCotisation" value="${empty cotisation ? '' : cotisation.typeCotisation}">
                                        <label for="inputTypeCotisation">Type de cotisation</label>
                                    </div>

                                    <div class="form-floating mb-3">
                                        <input class="form-control" id="inputDatePaiement" type="date" placeholder="Date de paiement" name="datePaiement" value="${empty cotisation ? '' : cotisation.datePaiement}">
                                        <label for="inputDatePaiement">Date de paiement</label>
                                    </div>
                                    <div class="mt-4 mb-0">
                                        <button class="btn btn-primary btn-block" type="submit">
                                            <c:choose>
                                                <c:when test="${empty cotisation}">
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
                                <div class="small"><a href="cotisations?action=list">Retour à la liste des cotisations</a></div>
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
<script>
        <% if (session.getAttribute("message") != null) { %>
            Swal.fire({
                icon: '<%= session.getAttribute("alertType") %>',
                title: '<%= session.getAttribute("message") %>'
            });
            <% 
                session.removeAttribute("message");
                session.removeAttribute("alertType");
            %>
        <% } %>
    </script>
</body>
</html>
