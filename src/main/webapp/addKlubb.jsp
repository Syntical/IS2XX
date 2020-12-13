<%--
  Created by IntelliJ IDEA.
  User: 99kev
  Date: 05.10.2020
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Legg til klubb</title>
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
    <li><a href="AdminSide.jsp">Forside </a></li>
    <li style="float:left"><button class="button" onclick="goBack()">Gå tilbake</button>
        <script>
            function goBack() {
                window.history.back();
            }
        </script></li>
</ul>
<div class="LeggTilBruker">
<form action='AddKlubb' method="POST">
    <label for='kb'>Legg til klubb:</label>
    <input type='text' name='kb' required/>
    <br>

    <input type='submit' name="action" value="Legg til klubb"/>
</form>
</div>


</body>
</html>
