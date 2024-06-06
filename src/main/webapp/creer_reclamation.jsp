<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Créer une Réclamation</title>
</head>
<body>
    <h1>Créer une Réclamation</h1>
    <form action="/reclamations" method="post">
    	 <input type="hidden" name="action" value="ajouter">
        <label for="nomAssure">NSS:</label>
        <input type="text" id="numeroSecSoc" name="numeroSecSoc" required><br><br>
        
        <input type="hidden" name="action" value="ajouter">
        <label for="nomAssure">Nom de l'Assuré:</label>
        <input type="text" id="nomAssure" name="nomAssure" required><br><br>

        <label for="prenomAssure">Prénom de l'Assuré:</label>
        <input type="text" id="prenomAssure" name="prenomAssure" required><br><br>

        <label for="sujet">Sujet:</label>
        <input type="text" id="sujet" name="sujet" required><br><br>

        <label for="description">Description:</label><br>
        <textarea id="description" name="description" rows="4" cols="50" required></textarea><br><br>

        <label for="dateReclamation">Date de Réclamation:</label>
        <input type="date" id="dateReclamation" name="dateReclamation" required><br><br>

        <input type="submit" value="Ajouter">
    </form>
</body>
</html>
