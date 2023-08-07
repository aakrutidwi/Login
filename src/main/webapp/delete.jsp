<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Delete User</title>
</head>
<body>

<%
    try {
        Class.forName("org.mariadb.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/validate?user=root&password=root");

        int id = Integer.parseInt(request.getParameter("id"));

        Statement st = conn.createStatement();
        int i = st.executeUpdate("DELETE FROM employee WHERE id=" + id);

        st.close();
        conn.close();

        out.println("Data Deleted Successfully!");
    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
        out.println("Error occurred while deleting the data.");
    }
%>

</body>
</html>
