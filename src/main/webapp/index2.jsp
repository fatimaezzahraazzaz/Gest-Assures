<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bienvenue</title>
    <%@ include file="/include2/css.jsp" %>
    
    
</head>
<body>
<!-- Spinner Start -->
    <div
      id="spinner"
      class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
      <div class="spinner-grow text-primary" role="status"></div>
    </div>
    <!-- Spinner End -->
	<%@ include file="/include2/header.jsp" %>
	<%@ include file="/include2/navbar.jsp" %>
	
	<div class="container-fluid p-0 mb-5 wow fadeIn" data-wow-delay="0.1s">
    <div id="header-carousel" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img class="w-100" src="Template2/img/carousel-1.jpg" alt="Image" />
                <div class="carousel-caption">
                    <div class="container">
                        <div class="row">
                            <div class="col-12 col-lg-6">
                                <h1 class="display-3 text-dark mb-4 animated slideInDown">
                                    L'assurance crée de la richesse pour tout le monde
                                </h1>
                                <p class="fs-5 text-body mb-5">
                                    La sécurité financière est un pilier essentiel pour la prospérité de chacun.
                                </p>
                                 <a href="index2.jsp" class="btn btn-primary py-3 px-5">En savoir plus</a>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="carousel-item">
                <img class="w-100" src="Template2/img/carousel-2.jpg" alt="Image" />
                <div class="carousel-caption">
                    <div class="container">
                        <div class="row">
                            <div class="col-12 col-lg-6">
                                <h1 class="display-3 text-dark mb-4 animated slideInDown">
                                    La meilleure assurance commence ici
                                </h1>
                                <p class="fs-5 text-body mb-5">
                                    La tranquillité d'esprit commence par une assurance de qualité.
                                </p>
                                <a href="index2.jsp" class="btn btn-primary py-3 px-5">En savoir plus</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#header-carousel" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Précédent</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#header-carousel" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Suivant</span>
        </button>
    </div>
</div>


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
                  <h5 class="mb-0">Appelez-nous : +212 06 50 603 702 </h5>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- About End -->
    <!-- Facts Start -->
    <div class="container-fluid overflow-hidden my-5 px-lg-0">
      <div class="container facts px-lg-0">
        <div class="row g-0 mx-lg-0">
          <div class="col-lg-6 facts-text wow fadeIn" data-wow-delay="0.1s">
            <div class="h-100 px-4 ps-lg-0">
              <h1 class="text-white mb-4">Pour les particuliers et les organisations</h1>
              <p class="text-light mb-5">
                Nous proposons des solutions d'assurance adaptées aussi bien aux particuliers qu'aux organisations.
                 Notre expertise nous permet de répondre à vos besoins spécifiques 
                 avec des produits et des services de qualité.
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
    <!-- Facts End -->

    <!-- Features Start -->
    <div class="container-xxl py-5">
      <div class="container">
        <div class="row g-5">
          <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.1s">
            <h1 class="display-6 mb-5">Quelques raisons pour lesquelles les gens nous choisissent !</h1>
            <p class="mb-4">
              T   Nous offrons une gamme de services d'assurance conçus pour répondre aux besoins divers de nos clients. 
              Notre engagement envers l'excellence et notre approche personnalisée font 
              de nous le choix préféré pour ceux qui recherchent une protection fiable et adaptée.
            </p>
            <div class="row g-3">
              <div class="col-sm-6 wow fadeIn" data-wow-delay="0.1s">
                <div class="bg-light rounded h-100 p-3">
                  <div
                    class="bg-white d-flex flex-column justify-content-center text-center rounded h-100 py-4 px-3"
                  >
                    <img
                      class="align-self-center mb-3"
                      src="Template2/img/icon/icon-06-primary.png"
                      alt=""
                    />
                    <h5 class="mb-0">Processus Facile</h5>
                  </div>
                </div>
              </div>
              <div class="col-sm-6 wow fadeIn" data-wow-delay="0.2s">
                <div class="bg-light rounded h-100 p-3">
                  <div
                    class="bg-white d-flex flex-column justify-content-center text-center rounded py-4 px-3"
                  >
                    <img
                      class="align-self-center mb-3"
                      src="Template2/img/icon/icon-03-primary.png"
                      alt=""
                    />
                    <h5 class="mb-0">Livraison rapide</h5>
                  </div>
                </div>
              </div>
              <div class="col-sm-6 wow fadeIn" data-wow-delay="0.3s">
                <div class="bg-light rounded h-100 p-3">
                  <div
                    class="bg-white d-flex flex-column justify-content-center text-center rounded py-4 px-3"
                  >
                    <img
                      class="align-self-center mb-3"
                      src="Template2/img/icon/icon-04-primary.png"
                      alt=""
                    />
                    <h5 class="mb-0">Contrôle  des politique </h5>
                  </div>
                </div>
              </div>
              <div class="col-sm-6 wow fadeIn" data-wow-delay="0.4s">
                <div class="bg-light rounded h-100 p-3">
                  <div
                    class="bg-white d-flex flex-column justify-content-center text-center rounded h-100 py-4 px-3"
                  >
                    <img
                      class="align-self-center mb-3"
                      src="Template2/img/icon/icon-07-primary.png"
                      alt=""
                    />
                    <h5 class="mb-0">Economie D'argent</h5>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.5s">
            <div
              class="position-relative rounded overflow-hidden h-100"
              style="min-height: 400px"
            >
              <img
                class="position-absolute w-100 h-100"
                src="Template2/img/feature.jpg"
                alt=""
                style="object-fit: cover"
              />
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Features End -->
    <!-- Service Start -->
    <div class="container-xxl py-5">
      <div class="container">
        <div class="text-center mx-auto" style="max-width: 500px">
          <h1 class="display-6 mb-5">
           Nous fournissons des services d'assurance professionnels
          </h1>
        </div>
        <div class="row g-4 justify-content-center">
          <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.1s">
            <div class="service-item rounded h-100 p-5">
              <div class="d-flex align-items-center ms-n5 mb-4">
                <div
                  class="service-icon flex-shrink-0 bg-primary rounded-end me-4"
                >
                  <img
                    class="img-fluid"
                    src="Template2/img/icon/icon-10-light.png"
                    alt=""
                  />
                </div>
                <h4 class="mb-0">Assurance-vie</h4>
              </div>
              <p class="mb-4">
                 Nous offrons une gamme complète de solutions d'assurance vie pour protéger votre avenir financier et celui de votre famille.
              </p>
              
            </div>
          </div>
          <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.3s">
            <div class="service-item rounded h-100 p-5">
              <div class="d-flex align-items-center ms-n5 mb-4">
                <div
                  class="service-icon flex-shrink-0 bg-primary rounded-end me-4"
                >
                  <img
                    class="img-fluid"
                    src="Template2/img/icon/icon-01-light.png"
                    alt=""
                  />
                </div>
                <h4 class="mb-0">Assurance Santé</h4>
              </div>
              <p class="mb-4">
               Protégez votre bien-être et celui de votre famille avec notre assurance santé complète et flexible.
              </p>
              
            </div>
          </div>
          <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.5s">
            <div class="service-item rounded h-100 p-5">
              <div class="d-flex align-items-center ms-n5 mb-4">
                <div
                  class="service-icon flex-shrink-0 bg-primary rounded-end me-4"
                >
                  <img
                    class="img-fluid"
                    src="Template2/img/icon/icon-05-light.png"
                    alt=""
                  />
                </div>
                <h4 class="mb-0">Assurance Habitation</h4>
              </div>
              <p class="mb-4">
                 Protégez votre maison et vos biens avec notre assurance habitation sur mesure.
              </p>
             
            </div>
          </div>
          <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.1s">
            <div class="service-item rounded h-100 p-5">
              <div class="d-flex align-items-center ms-n5 mb-4">
                <div
                  class="service-icon flex-shrink-0 bg-primary rounded-end me-4"
                >
                  <img
                    class="Template2/img-fluid"
                    src="Template2/img/icon/icon-08-light.png"
                    alt=""
                  />
                </div>
                <h4 class="mb-0">Assurance automobile</h4>
              </div>
              <p class="mb-4">
                 Protégez votre véhicule avec notre assurance automobile complète.
             
            </div>
          </div>
          <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.3s">
            <div class="service-item rounded h-100 p-5">
              <div class="d-flex align-items-center ms-n5 mb-4">
                <div
                  class="service-icon flex-shrink-0 bg-primary rounded-end me-4"
                >
                  <img
                    class="img-fluid"
                    src="Template2/img/icon/icon-07-light.png"
                    alt=""
                  />
                </div>
                <h4 class="mb-0">Assurance entreprise</h4>
              </div>
              <p class="mb-4">
                 Protégez votre entreprise avec notre assurance adaptée aux besoins des entreprises.
              </p>
              
            </div>
          </div>
          <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.5s">
            <div class="service-item rounded h-100 p-5">
              <div class="d-flex align-items-center ms-n5 mb-4">
                <div
                  class="service-icon flex-shrink-0 bg-primary rounded-end me-4"
                >
                  <img
                    class="img-fluid"
                    src="Template2/img/icon/icon-06-light.png"
                    alt=""
                  />
                </div>
                <h4 class="mb-0">Assurance propriété</h4>
              </div>
              <p class="mb-4">
               Protégez votre propriété et vos biens avec notre assurance propriété fiable.

              </p>
              
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Service End -->

<%@ include file="/include2/Footer.jsp" %>
<!-- Back to Top -->
    <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"
      ><i class="bi bi-arrow-up"></i
    ></a>
</body>
<script src="Template2/js/main.js"></script>
<%@ include file="/include2/js.jsp" %>
</html>
