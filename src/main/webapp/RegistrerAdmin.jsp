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
    <title>Registrer Admin</title>
    <link href='test.css' type='text/css' rel='stylesheet'>
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

<div class="LeggTilBruker">
<form action="RegistrerBruker" method="POST">
    <label for='bn'>Brukernavn:</label>
    <input type='text' name='bn'/>
    <br>
    <label for='pd'>Passord:</label>
    <input type='text' name='pd'/>
    <br>
    <input type='submit' name="action" value="Registrer"/>
</form>
</div>
</body>
</html>
