<%--
  Created by IntelliJ IDEA.
  User: dalaria
  Date: 01.10.2020
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Style.css" />
<html>
<head>
    <title>Legg til bruker</title>
</head>
<body>
<h1>Legg til bruker i databasen</h1>
<form action='AddBruker' method='POST'>
    <label for='fn'>Fornavn:</label>
    <input type='text' name='fn'/>
    <br>
    <label for='en'> Etternavn:</label>
    <input type='text' name='en'/>
    <br>
    <label for='vk'>      Vekt:</label>
    <input type='text' name='vk'/>
    <br>
    <input type='submit' name="action" value="add"/>
    </form>

<form action="AddBruker" method="POST">
    <input type="submit" name="action" value="hent">
    <a href="index.jsp">Forsiden</a>
</form>
<form>

</form>
</body>
</html>
