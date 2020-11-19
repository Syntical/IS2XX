<%--
  Created by IntelliJ IDEA.
  User: 99kev
  Date: 13.11.2020
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="tools.DbTool" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.sql.ResultSet" %>
<html>
<head>
    <title>Title</title>

    <form action='velgTG' method='post'>

        <label for="tg">Testgruppe:</label>
        <select id="tg" name="tg">
            <option value=""> Velg testgruppe </option>
                <%
            PrintWriter l = new PrintWriter(out);
            Connection ddb = null;
            PreparedStatement gruppe = null;
            try {
                ddb = DbTool.getINSTANCE().dbLoggIn(l);
                ResultSet rs = null;
                String query = "SELECT * FROM Testgruppe";
                gruppe = ddb.prepareStatement(query);
                rs = gruppe.executeQuery();
                while (rs.next())
                {
        %>
            <option value="<%=rs.getInt("testgruppe_id") %>"><%=rs.getString("TestGruppeNavn")%>
            </option>
                <%
                }
            } catch (SQLException e ) {
                e.printStackTrace();
            }
        %>

            <input type='submit' name="action" value="gå videre"/>
    </form>




</head>
<body>

</body>
</html>
