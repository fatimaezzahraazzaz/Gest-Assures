<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Gestion de votre Dossier Médical</title>
</head>
<body>
    <h1>Gestion de votre Dossier Médical</h1>
    <p>Bienvenue, ${sessionScope.username}</p>

    <c:choose>
        <c:when test="${not empty dossierMedical}">
            <h2>Modifier le Dossier Médical :</h2>
            <form action="DossierMedicalServlet" method="post">
                <!-- Champs du formulaire pour l'édition -->
                <input type="hidden" name="action" value="update">
                <input type="hidden" name="id" value="${dossierMedical.id}">
                <div>
                    <label for="inputNumeroSecu">Numéro Sécurité Sociale</label>
                    <input id="inputNumeroSecu" type="text" name="numeroSecu" value="${dossierMedical.numeroSecu}">
                </div>
                <div>
                    <label for="inputGroupeSanguin">Groupe Sanguin</label>
                    <input id="inputGroupeSanguin" type="text" name="GroupeSanguin" value="${dossierMedical.groupeSanguin}">
                </div>
                <!-- Ajoutez d'autres champs de formulaire pour l'édition selon vos besoins -->
                <button type="submit">Enregistrer</button>
            </form>
        </c:when>
        <c:otherwise>
            <h2>Créer un Dossier Médical :</h2>
            <form action="DossierMedicalServlet" method="post">
                <!-- Champs du formulaire pour la création -->
                <input type="hidden" name="action" value="insert">
                <div>
                    <label for="inputNumeroSecu">Numéro Sécurité Sociale</label>
                    <input id="inputNumeroSecu" type="text" name="numeroSecu">
                </div>
                <div>
                    <label for="inputGroupeSanguin">Groupe Sanguin</label>
                    <input id="inputGroupeSanguin" type="text" name="GroupeSanguin">
                </div>
                <!-- Ajoutez d'autres champs de formulaire pour la création selon vos besoins -->
                <button type="submit">Créer</button>
            </form>
        </c:otherwise>
    </c:choose>
</body>
</html>
