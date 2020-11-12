
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
        <input type="submit" value="Logg ut" /></form></li>
    <li style="float:left"><button class="button" onclick="goBack()">Gå tilbake</button>
        <script>
            function goBack() {
                window.history.back();
            }
        </script></li>
</ul>

<div class="LeggTilBruker">
<form action="AddArogUke" method="POST">
    <label for='ar'>testår</label>
    <input type='text' name='ar'/>
    <br>
    <label for='uke'>Testuke:</label>
    <input type='text' name='uke'/>
    <input type='submit' name="action" value="Leggt"/>



</form>
</div>


</body>
</html>
