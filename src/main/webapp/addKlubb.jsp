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
</head>
<body>

<link rel="stylesheet" href="test.css"/>
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
<form action='AddKlubb' method="POST">
    <label for='kb'>legg til klubb:</label>
    <input type='text' name='kb'/>
    <br>

    <input type='submit' name="action" value="addklubb"/>
</form>
</div>


</body>
</html>
