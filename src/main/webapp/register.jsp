<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>Register </title>
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
                                <div class="card-header"><h3 class="text-center font-weight-light my-4">Create Account</h3></div>
                                <div class="card-body">
                                    <form action="register" method="post">
                                        <div class="row mb-3">
                                            <div class="col-md-6">
                                                <div class="form-floating mb-3 mb-md-0">
                                                    <input class="form-control" id="nom" type="text" name="nom" placeholder="Enter your first name" required />
                                                    <label for="nom">First name</label>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-floating">
                                                    <input class="form-control" id="prenom" type="text" name="prenom" placeholder="Enter your last name" required />
                                                    <label for="prenom">Last name</label>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-floating mb-3">
                                            <input class="form-control" id="numeroSecSoc" type="text" name="numeroSecSoc" placeholder="Social Security Number" required />
                                            <label for="numeroSecSoc">Social Security Number</label>
                                        </div>
                                        <div class="form-floating mb-3">
                                            <input class="form-control" id="adresse" type="text" name="adresse" placeholder="Address" required />
                                            <label for="adresse">Address</label>
                                        </div>
                                        <div class="form-floating mb-3">
                                            <input class="form-control" id="dateNaissance" type="date" name="dateNaissance" placeholder="Date of Birth" required />
                                            <label for="dateNaissance">Date of Birth</label>
                                        </div>
                                        <div class="form-floating mb-3">
                                            <input class="form-control" id="username" type="text" name="username" placeholder="Username" required />
                                            <label for="username">Username</label>
                                        </div>
                                        <div class="row mb-3">
                                            <div class="col-md-6">
                                                <div class="form-floating mb-3 mb-md-0">
                                                    <input class="form-control" id="password" type="password" name="password" placeholder="Create a password" required />
                                                    <label for="password">Password</label>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-floating mb-3 mb-md-0">
                                                    <input class="form-control" id="confirmPassword" type="password" name="confirmPassword" placeholder="Confirm password" required />
                                                    <label for="confirmPassword">Confirm Password</label>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="mt-4 mb-0">
                                            <div class="d-grid"><button class="btn btn-primary btn-block" type="submit">Create Account</button></div>
                                        </div>
                                    </form>
                                </div>
                                <div class="card-footer text-center py-3">
                                    <div class="small"><a href="login.jsp">Have an account? Go to login</a></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </main>
             <%@ include file="/include/css.jsp" %>
        </div>

<%@ include file="/include/js.jsp" %>
</body>
</html>
