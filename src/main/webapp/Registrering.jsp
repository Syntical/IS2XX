<%--
  Created by IntelliJ IDEA.
  User: 99kev
  Date: 12.10.2020
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="tools.DbTool" %>
<%@ page import="java.io.PrintWriter" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<form action="RegistrerBruker" method="POST">
    <label for='bn'>Brukernavn:</label>
    <input type='text' name='bn'/>
    <br>
    <label for='pd'>Passord:</label>
    <input type='text' name='pd'/>
    <input type='submit' name="action" value="Registrer"/>

    <label>Rolle:</label>
    <select>
        <option value="-1"> Velg rolle </option>
        <%
            PrintWriter p = new PrintWriter(out);
            Connection db = null;
            PreparedStatement dropDown = null;
            try {
                db = DbTool.getINSTANCE().dbLoggIn(p);
                ResultSet rs = null;
                String query = "SELECT * FROM roller";
                dropDown = db.prepareStatement(query);
                rs = dropDown.executeQuery();
                while (rs.next())
                {
        %>
        <option value="<%=rs.getInt("rolle_id") %>"><%=rs.getString("rolletype")%>
        </option>
        <%
                }
            } catch (SQLException e ) {
                e.printStackTrace();
            }
        %>
    </select>
</form>

</body>
</html>
