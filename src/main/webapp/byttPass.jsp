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
    <link rel="stylesheet" href="test.css"/>
</head>
<body>
    <ul>
        <li><form action="${pageContext.request.contextPath}/LoggUt" method="post">
            <input type="submit" value="Logg ut" /></form>
        <li><a href="addKlubb.jsp">Legg til klubb</a></li>
        <li><a href="AddTestgruppe.jsp">Legg til testklasse</a></li>
        <li><a href="Testår.jsp">Legg til testår og -uke</a></li>
        <li><a href="Klubboversikt.jsp">Klubboversikt</a></li>
        <li><a href="RegistrerNyBruker.jsp">Registrer ny systembruker</a></li>
        <li style="float:left"><button class="button" onclick="goBack()">Gå tilbake</button>
            <script>
                function goBack() {
                    window.history.back();
                }
            </script></li>
    </ul>
    <form action='velgbruker' method='post'>

        <label for="bk">Type bruker:</label>
        <select id="bk" name="bk">
            <option value=""> Velg testgruppe </option>
                <%
            PrintWriter l = new PrintWriter(out);
            Connection ddb = null;
            PreparedStatement gruppe = null;
            try {
                ddb = DbTool.getINSTANCE().dbLoggIn(l);
                ResultSet rs = null;
                String query = "SELECT * FROM roller";
                gruppe = ddb.prepareStatement(query);
                rs = gruppe.executeQuery();
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

            <input type='submit' name="action" value="gå videre"/>
    </form>


</body>
</html>
