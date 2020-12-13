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
    <link rel="stylesheet" href="test.css"/>
    <title>Velg testgruppe</title>
</head>

<body>
<ul>
    <li><form action="${pageContext.request.contextPath}/LoggUt" method="post">
        <input type="submit" value="Logg ut" /></form></li>
    <li><form action="${pageContext.request.contextPath}/VisUtoevereiKlubb" method="post">
        <input type="submit" value="Vis utøvere i klubben" />
    </form>
    </li>
    <li><a href="AddBruker.jsp">Legg til utøver</a></li>
    <li><a href="Velgtestgruppe.jsp">Testklasser </a></li>
    <li style="float:left"><button class="button" onclick="goBack()">Gå tilbake</button>
        <script>
            function goBack() {
                window.history.back();
            }
        </script></li>
</ul>
<br>
<br>
    <div class="BrukerReg">
    <form action='velgTG' method='post'>

        <label for="tg">Testklasse:</label>
        <select id="tg" name="tg" style="width: 200px">
            <option value=""> Velg testklasse </option>
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
            <br>
            <br>
            <input type='submit' name="action" value="Hent"/>
    </form>
    </div>

</body>
</html>
