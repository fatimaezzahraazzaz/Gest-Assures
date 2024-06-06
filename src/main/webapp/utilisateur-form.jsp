<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Formulaire d'utilisateur</title>
    <%@ include file="/include/css.jsp" %>
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
                                            <c:when test="${empty utilisateur}">
                                                Ajouter un nouvel utilisateur
                                            </c:when>
                                            <c:otherwise>
                                                Modifier un utilisateur
                                            </c:otherwise>
                                        </c:choose>
                                    </h3>
                                </div>
                                <div class="card-body">
                                    <form action="utilisateurs" method="post">
                                        <c:choose>
                                            <c:when test="${empty utilisateur}">
                                                <input type="hidden" name="action" value="insert">
                                            </c:when>
                                            <c:otherwise>
                                                <input type="hidden" name="action" value="update">
                                                <input type="hidden" name="id" value="${utilisateur.id}">
                                            </c:otherwise>
                                        </c:choose>
                                        <div class="form-floating mb-3">
                                            <input class="form-control" id="inputUsername" type="text" placeholder="Nom d'utilisateur" name="username" value="${empty utilisateur ? '' : utilisateur.username}">
                                            <label for="inputUsername">Nom d'utilisateur</label>
                                        </div>
                                        <div class="form-floating mb-3">
                                            <input class="form-control" id="inputPassword" type="password" placeholder="Mot de passe" name="password" value="${empty utilisateur ? '' : utilisateur.password}">
                                            <label for="inputPassword">Mot de passe</label>
                                        </div>
                                        <div class="form-floating mb-3">
                                            <input class="form-control" id="inputRole" type="text" placeholder="Rôle" name="role" value="${empty utilisateur ? '' : utilisateur.role}">
                                            <label for="inputRole">Rôle</label>
                                        </div>
                                        <div class="mt-4 mb-0">
                                            <button class="btn btn-primary btn-block" type="submit">
                                                <c:choose>
                                                    <c:when test="${empty utilisateur}">
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
                                    <div class="small"><a href="utilisateurs?action=list">Retour à la liste des utilisateurs</a></div>
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
