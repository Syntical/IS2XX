<%--
  Created by IntelliJ IDEA.
  User: mrbee
  Date: 19.10.2020
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Legg til testgruppe</title>
    <link rel="stylesheet" href="test.css" />
</head>
<body>
<ul>
    <li><form action="${pageContext.request.contextPath}/LoggUt" method="post">
        <input type="submit" value="Logg ut" /></form></li>
    <li><a href="AddBruker.jsp">Legg til medlem</a></li>
    <li style="float:left"><button class="button" onclick="goBack()">Gå tilbake</button>
        <script>
            function goBack() {
                window.history.back();
            }
        </script></li>
</ul>
    <div class="LeggTilBruker">
        <form action='addtestgruppe' method='POST'>
            <label for='tgn'>Testgruppenavn:</label>

            <input type='text' name='tgn'/>
            <input type='submit' name="action" value="leggTilTestgruppe"/>
        </form>
    </div>
</body>
</html>
