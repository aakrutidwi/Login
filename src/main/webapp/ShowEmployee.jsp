<%@ page import="java.sql.*" %>
<%@ page import="com.unoveo.dbutils.DButils" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>List of Registered Users</title>
    <!-- Add Bootstrap CSS link -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<jsp:include page="header.jsp" />

<div class="container mt-4">
    <h2>List of Registered Users</h2>
    <div class="table-responsive"> <!-- Wrap the table in a responsive container -->
        <table class="table table-hover">
            <thead>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Age</th>
                <th>City</th>
                <th>Delete</th>
            </tr>
            </thead>
            <tbody>
                <%
                try {
                    Connection cn = DButils.getCn();
                    Statement statement = cn.createStatement();
                    ResultSet resultSet = statement.executeQuery("SELECT * FROM employee");
                    while (resultSet.next()){
                        String firstName = resultSet.getString("firstname");
                        String lastName = resultSet.getString("lastname");
                        int age = resultSet.getInt("age");
                        String city = resultSet.getString("city");
                        int id = resultSet.getInt("id");
                %>
                <tr>
                    <td><%= firstName %></td>
                    <td><%= lastName %></td>
                    <td><%= age %></td>
                    <td><%= city %></td>
                    <td>
                        <a href="delete.jsp?id=<%= id %>" class="btn btn-primary">Delete</a>
                    </td>
                    <td>
                       <a href="update.jsp?id=<%=resultSet.getString("id")%>" class="btn btn-primary">Update</a>
                     </td>
                </tr>
                <%
                    }
                    resultSet.close();
                    statement.close();
                    cn.close();
                } catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                }
                %>
            </tbody>
        </table>
    </div>

    <!-- Add "Add" button that redirects to add_user.jsp -->
    <a href="registration.jsp" class="btn btn-primary float-right">Add User</a>
</div>

<jsp:include page="footer.jsp" />

<!-- Add Bootstrap JS and jQuery scripts for table functionality (optional) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
