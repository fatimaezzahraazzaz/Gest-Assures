<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>À propos de nous</title>
 <%@ include file="/include2/css.jsp" %>

</head>
<body>
 <%@ include file="/include2/header.jsp" %>
 <%@ include file="/include2/navbar.jsp" %>
  <!-- Page Header Start -->
    <div
      class="container-fluid page-header py-5 mb-5 wow fadeIn"
      data-wow-delay="0.1s"
    >
      <div class="container py-5">
        <h1 class="display-4 animated slideInDown mb-4">À propos de nous </h1>
        <nav aria-label="breadcrumb animated slideInDown">
          <ol class="breadcrumb mb-0">
            <li class="breadcrumb-item"><a href="index2.jsp">Home</a></li>
            <li class="breadcrumb-item active" aria-current="page">À propos </li>
          </ol>
        </nav>
      </div>
    </div>
    <!-- Page Header End -->
 
	<!-- About Start -->
    <div class="container-xxl py-5">
      <div class="container">
        <div class="row g-5">
          <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.1s">
            <div
              class="position-relative overflow-hidden rounded ps-5 pt-5 h-100"
              style="min-height: 400px"
            >
              <img
                class="position-absolute w-100 h-100"
                src="Template2/img/about.jpg"
                alt=""
                style="object-fit: cover"
              />
              <div
                class="position-absolute top-0 start-0 bg-white rounded pe-3 pb-3"
                style="width: 200px; height: 200px"
              >
                <div
                  class="d-flex flex-column justify-content-center text-center bg-primary rounded h-100 p-3"
                >
                  <h1 class="text-white mb-0">7</h1>
                  <h2 class="text-white">Ans</h2>
                  <h5 class="text-white mb-0">D'éxpérience</h5>
                </div>
              </div>
            </div>
          </div>
          <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.5s">
            <div class="h-100">
              <h1 class="display-6 mb-5">
               Nous sommes là pour vous aider à explorer la protection
              </h1>
              <p class="fs-5 text-primary mb-4">
               Dess années d'expérience nous permettent de vous offrir les meilleures solutions d'assurance adaptées à vos besoins.
              </p>
              <div class="row g-4 mb-4">
                <div class="col-sm-6">
                  <div class="d-flex align-items-center">
                    <img
                      class="flex-shrink-0 me-3"
                      src="Template2/img/icon/icon-04-primary.png"
                      alt=""
                    />
                    <h5 class="mb-0">Plans d'assurance flexibles</h5>
                  </div>
                </div>
                <div class="col-sm-6">
                  <div class="d-flex align-items-center">
                    <img
                      class="flex-shrink-0 me-3"
                      src="Template2/img/icon/icon-03-primary.png"
                      alt=""
                    />
                    <h5 class="mb-0">Garantie de remboursement</h5>
                  </div>
                </div>
              </div>
              <p class="mb-4">
                  Nous vous accompagnons tout au long de votre parcours pour vous offrir la meilleure protection possible. Faites-nous confiance pour votre tranquillité d'esprit.
              </p>
             
              <div class="border-top mt-4 pt-4">
                <div class="d-flex align-items-center">
                  <img
                    class="flex-shrink-0 rounded-circle me-3"
                    src="Template2/img/profile.jpg"
                    alt=""
                  />
                  <h5 class="mb-0">Appelez-nous : +</h5>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="container-fluid overflow-hidden my-5 px-lg-0">
      <div class="container facts px-lg-0">
        <div class="row g-0 mx-lg-0">
          <div class="col-lg-6 facts-text wow fadeIn" data-wow-delay="0.1s">
            <div class="h-100 px-4 ps-lg-0">
              <h1 class="text-white mb-4">Pour les particuliers et les organisations</h1>
              <p class="text-light mb-5">
                Nous proposons des solutions d'assurance adaptées aussi bien aux particuliers qu'aux organisations. Notre expertise nous permet de répondre à vos besoins spécifiques avec des produits et des services de qualité.
              </p>
              <a href="" class="align-self-start btn btn-secondary py-3 px-5"
                >Plus de détails</a
              >
            </div>
          </div>
          <div class="col-lg-6 facts-counter wow fadeIn" data-wow-delay="0.5s">
            <div class="h-100 px-4 pe-lg-0">
              <div class="row g-5">
                <div class="col-sm-6">
                  <h1 class="display-5" data-toggle="counter-up">1234</h1>
                  <p class="fs-5 text-primary">Clients satisfaits</p>
                </div>
                <div class="col-sm-6">
                  <h1 class="display-5" data-toggle="counter-up">1234</h1>
                  <p class="fs-5 text-primary">Les projets réussissent</p>
                </div>
                <div class="col-sm-6">
                  <h1 class="display-5" data-toggle="counter-up">1234</h1>
                  <p class="fs-5 text-primary">Récompenses obtenues</p>
                </div>
                <div class="col-sm-6">
                  <h1 class="display-5" data-toggle="counter-up">1234</h1>
                  <p class="fs-5 text-primary">Membres de l'équipe</p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
 
 <%@ include file="/include2/Footer.jsp" %>
 
 
</body>
 <%@ include file="/include/js.jsp" %>
    <%@ include file="/include2/js.jsp" %>
    <script src="Template2/js/main.js"></script>
</html>