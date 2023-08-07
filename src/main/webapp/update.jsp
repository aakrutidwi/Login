<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update User</title>

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
<body>
<div class="container mt-5">
    <div class="row justify-content-center">
      <div class="col-md-6 form-container">
        <h1 class="text-center">Update User</h1>
        <form action="<%= request.getContextPath() %>/register" method="post">
          <div class="form-group">
            <label for="firstName">First Name</label>
            <input type="text" class="form-control" id="firstName" name="firstname" required>
          </div>
          <div class="form-group">
            <label for="lastName">Last Name</label>
            <input type="text" class="form-control" id="lastName" name="lastname" required>
          </div>
          <div class="form-group">
            <label for="age">Age</label>
            <input type="number" class="form-control" id="age" name="age" required>
          </div>
          <div class="form-group">
            <label for="city">City</label>
            <input type="text" class="form-control" id="city" name="city" required>
          </div>
          <button type="submit" class="btn btn-primary">Update User</button>
        </form>
      </div>
    </div>
  </div>
<%
    try {

        Class.forName("org.mariadb.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/validate?user=root&password=root");

        int id = Integer.parseInt(request.getParameter("id"));
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        System.out.println("Data updated"+id);

        int age = 0;
        String ageParam = request.getParameter("age");
        if (ageParam != null && !ageParam.isEmpty()) {
            age = Integer.parseInt(ageParam);
        }

        String city = request.getParameter("city");


        Statement st = conn.createStatement();

            String insert = "update employee set firstname=?, lastname=?,city=?, age=? where id=?";
            PreparedStatement preparedStatement = conn.prepareStatement(insert);

            preparedStatement.setString(1, firstname);
            preparedStatement.setString(2, lastname);
            preparedStatement.setInt(4, age);
            preparedStatement.setString(3, city);
            preparedStatement.setInt(5, id);


    int insertedData=preparedStatement.executeUpdate();

        st.close();
        conn.close();

    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
        out.println("Error occurred while updating the data.");
    }
%>

</body>
</html>
