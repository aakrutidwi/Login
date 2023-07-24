<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:include page="header.jsp" />

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <meta charset="ISO-8859-1">
    <title>Employee Register Form</title>
    <style>
        .login-container {
            border: 1px solid grey;
            padding: 20px;
            margin-top: 150px;
            width: 500px;
            margin-left: auto;
            margin-right: auto;
        }
        .btn{
            margin-top: 10px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="login-container">
        <form class="needs-validation" action="login" novalidate>
            <div class="mb-3">
                <label for="validationCustom01" class="form-label">Username</label>
                <input type="text" class="form-control" name="username" id="validationCustom01" required>
            </div>
            <div class="mb-3">
                <label for="validationCustom02" class="form-label">Password</label>
                <input type="password" class="form-control" name="encrep" id="validationCustom02"  required>
            </div>
            <button class="btn btn-primary" type="submit">Submit form</button>
        </form>
    </div>
</div>
<jsp:include page="footer.jsp" />
