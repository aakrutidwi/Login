<jsp:include page="header.jsp" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login Error</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <!-- Add the Bootstrap CSS link above to include Bootstrap styles -->
    <style>
        /* Additional custom styles can be added here */
        body {
            background-color: #f8f9fa;
        }
        .container {
            margin-top: 100px;
            text-align: center;
        }
        .error-heading {
            color: #dc3545;
            font-size: 30px;
            font-weight: bold;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="error-heading">Login Error! Invalid Username or Password</div>
        <p class="lead">Please check your username and password and try again.</p>

    </div>
</body>
</html>
<jsp:include page="footer.jsp" />

