<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Nouveau Dossier Médical</title>
</head>
<body>
    <h2>Ajouter un Nouveau Dossier Médical</h2>
    <form action="DossierMedicalServlet?action=add" method="post">
        <label>ID_Assure:</label>
        <input type="text" name="idAssure"><br>
        <label>Groupe Sanguin:</label>
        <input type="text" name="groupeSanguin"><br>
        <label>Allergies:</label>
        <input type="text" name="allergies"><br>
        <label>Antécédents Médicaux:</label>
        <input type="text" name="antecedentsMedicaux"><br>
        <label>Liste des Médicaments Prescrits:</label>
        <input type="text" name="listeMedicamentsPrescrits"><br>
        <input type="submit" value="Ajouter Dossier Médical">
    </form>
</body>
</html>