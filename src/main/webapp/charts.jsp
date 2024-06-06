<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <%@ include file="/include/css.jsp" %>
<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
</head>
<body>
 <%@ include file="/include/navbar.jsp" %>
<div id="layoutSidenav">
 <%@ include file="/include/sidebar.jsp" %>
<div id="layoutSidenav_content">

    <main>
        <div class="container-fluid px-4">
            <h1 class="mt-4">Statistiques</h1>
            <ol class="breadcrumb mb-4">
                <li class="breadcrumb-item"><a href="index.html">Tableau de bord</a></li>
                <li class="breadcrumb-item active">Statistiques</li>
            </ol>
            <!-- Graphique : Nombre d'assurés par mois -->
            <div class="card mb-4">
                <div class="card-header">
                    <i class="fas fa-chart-bar me-1"></i>
                    Nombre d'assurés par mois
                </div>
                <div class="card-body"><canvas id="assuresParMoisChart" width="100%" height="50"></canvas></div>
                <div class="card-footer small text-muted">Mis à jour hier à 23h59</div>
            </div>
            <!-- Graphique : Répartition des demandes acceptées et refusées -->
            <div class="card mb-4">
                <div class="card-header">
                    <i class="fas fa-chart-pie me-1"></i>
                    Répartition des demandes
                </div>
                <div class="card-body"><canvas id="demandesRepartitionChart" width="100%" height="50"></canvas></div>
                <div class="card-footer small text-muted">Mis à jour hier à 23h59</div>
            </div>
        </div>
    </main>
     <%@ include file="/include/footer.jsp" %>
</div>
</div>

<script>
    // Récupération des données depuis la servlet ou votre service
    var dataAssuresParMois = {
        labels: ["Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre"],
        datasets: [{
            label: 'Nombre d\'assurés',
            backgroundColor: 'rgba(75, 192, 192, 0.2)',
            borderColor: 'rgba(75, 192, 192, 1)',
            borderWidth: 1,
            data: [10, 20, 30, 25, 35, 45, 40, 50, 55, 60, 70, 65] // Remplacez ces données par celles que vous récupérez
        }]
    };

    // Configuration du graphique
    var configAssuresParMois = {
        type: 'bar',
        data: dataAssuresParMois,
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    };

    // Création du graphique
    var assuresParMoisChart = new Chart(
        document.getElementById('assuresParMoisChart'),
        configAssuresParMois
    );
</script>

<%@ include file="/include/js.jsp" %>
</body>
</html>
