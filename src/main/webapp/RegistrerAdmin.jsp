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

<ul>
    <li><form action="${pageContext.request.contextPath}/LoggUt" method="post">
        <input type="submit" value="Logg ut" /></form></li>
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
    <input type='submit' name="action" value="Registrer"/>
</form>
</div>
</body>
</html>
