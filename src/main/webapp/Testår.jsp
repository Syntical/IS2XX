
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="tools.DbTool" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Legg til testår</title>
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
<br>
<br>
<br>
<br>
<div class="Introduksjon">
    <h1>Legg til ny testperiode</h1>
</div>
<div class="LeggTilBruker">
<form action="AddArogUke" method="POST">
    <label for='ar'>Testår</label>
    <input type='text' name='ar' maxlength = "2" required/>
    <br>
    <label for='uke'>Testuke:</label>
    <input type='text' name='uke' maxlength = "2" required/>
    <input type='submit' name="action" value="Legg til testperiode"/>



</form>
</div>


</body>
</html>
