<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <%@ include file="/include/css.jsp" %>
        
     
  <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/sweetalert2@10">
</head>
<body class="bg-primary">
    <div id="layoutAuthentication">
        <div id="layoutAuthentication_content">
            <main>
                <div class="container">
                    <div class="row justify-content-center">
                        <div class="col-lg-5">
                            <div class="card shadow-lg border-0 rounded-lg mt-5">
                                <div class="card-header"><h3 class="text-center font-weight-light my-4">Login</h3></div>
                                <div class="card-body">
                                  
                                    <form action="login" method="post">
                                        <div class="form-floating mb-3">
                                            <input class="form-control" id="username" type="text" name="username" placeholder="Username" required>
                                            <label for="username">Username</label>
                                        </div>
                                        <div class="form-floating mb-3">
                                            <input class="form-control" id="password" type="password" name="password" placeholder="Password" required>
                                            <label for="password">Password</label>
                                        </div>
                                        
                                        <div class="d-flex align-items-center justify-content-between mt-4 mb-0">
                                           
                                            <button class="btn btn-primary" type="submit">Login</button>
                                        </div>
                                    </form>
                                </div>
                                <div class="card-footer text-center py-3">
    <div class="small">
        <a href="register.jsp">Need an account? Sign up!</a>
    </div>
</div>

                            </div>
                        </div>
                    </div>
                </div>
            </main>
              
        </div>
    </div>
     <%@ include file="/include/footer.jsp" %>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
   <script>
    // Récupérer le message d'erreur depuis l'attribut de requête
    var errorMessage = "<%= request.getAttribute("error") %>";

    // Vérifier si le message d'erreur est présent et non null
    if (errorMessage && errorMessage.trim().length > 0 && errorMessage.trim() !== "null") {
        // Afficher l'alerte Sweet Alert avec le message d'erreur
        Swal.fire({
            icon: 'error',
            title: 'Erreur!',
            text: errorMessage
        });
    }
</script>

        <%@ include file="/include/js.jsp" %>
</body>
 


</html>
