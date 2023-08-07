<jsp:include page="header.jsp" />
 <!-- <title>Employee Register Form</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
  <style>
    body {
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
      background-color: #f7f7f7; /* Optional: Adding a light background color */
    }

    .form-container {
      border: 1px solid #ddd; /* Gray border */
      padding: 20px;
      max-width: 400px; /* Optional: Limiting the form width */
    }
  </style>
-->

<body>
  <div class="container mt-5">
    <div class="row justify-content-center">
      <div class="col-md-6 form-container">
        <h1 class="text-center">Register New User</h1>
        <form action="<%= request.getContextPath() %>/registeruser" method="post">
          <div class="form-group">
            <label for="username">User Name</label>
            <input type="text" class="form-control" id="username" name="username" required>
          </div>
          <div class="form-group">
            <label for="password">Password</label>
            <input type="password" class="form-control" id="password" name="password" required>
          </div>
          <button type="submit" class="btn btn-primary">Register</button>
        </form>
      </div>
    </div>
  </div>

<jsp:include page="footer.jsp" />



